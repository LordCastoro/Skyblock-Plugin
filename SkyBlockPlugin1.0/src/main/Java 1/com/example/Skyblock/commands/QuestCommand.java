package com.example.skyblock.commands;

import com.example.skyblock.managers.QuestManager;
import com.example.skyblock.models.Quest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuestCommand implements CommandExecutor {

    private final QuestManager questManager;

    public QuestCommand(QuestManager questManager) {
        this.questManager = questManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                switch (args[0].toLowerCase()) {
                    case "start":
                        if (args.length > 1) {
                            String questName = args[1];
                            // Creazione di una missione esemplare. In un caso reale, si caricherebbero le missioni da un database o file.
                            Quest quest = new Quest(questName, "Completa la missione " + questName);
                            questManager.assignQuest(player, quest);
                        } else {
                            player.sendMessage("Specifica una missione da avviare.");
                        }
                        break;
                    case "complete":
                        if (questManager.completeQuest(player)) {
                            player.sendMessage("Missione completata!");
                        } else {
                            player.sendMessage("Non hai ancora completato la missione.");
                        }
                        break;
                    case "status":
                        Quest activeQuest = questManager.getActiveQuest(player);
                        if (activeQuest != null) {
                            player.sendMessage("Missione attiva: " + activeQuest.getName());
                            player.sendMessage("Descrizione: " + activeQuest.getDescription());
                        } else {
                            player.sendMessage("Non hai missioni attive.");
                        }
                        break;
                    default:
                        player.sendMessage("Comando sconosciuto. Usa /quest <start|complete|status>.");
                        break;
                }
            } else {
                player.sendMessage("Usa /quest <comando>.");
            }
            return true;
        }
        return false;
    }
}
