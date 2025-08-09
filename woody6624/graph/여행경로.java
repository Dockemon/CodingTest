import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        int number = tickets.length;
        List<String[]> ticketPod = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            if (tickets[i][0].equals("ICN")) {
                boolean[] checkTicket = new boolean[number];
                checkTicket[i] = true;
                String[] singleResult = new String[number + 1];
                singleResult[0] = "ICN";            
                singleResult[1] = tickets[i][1];    
                dfs(i, tickets, checkTicket, ticketPod, 2, singleResult);
            }
        }

        return ticketPod.stream()
            .min(Comparator.comparing(Arrays::toString))
            .get();
    }

    private void dfs(int currentTicketIdx, String[][] tickets, boolean[] checkTicket,
                     List<String[]> ticketPod, int depth, String[] singleResult) {

        int number = tickets.length;

        if (depth == number + 1) {  
            ticketPod.add(singleResult.clone());
            return;
        }

        for (int i = 0; i < number; i++) {
            if (!checkTicket[i] && tickets[currentTicketIdx][1].equals(tickets[i][0])) {
                checkTicket[i] = true;
                singleResult[depth] = tickets[i][1];
                dfs(i, tickets, checkTicket, ticketPod, depth + 1, singleResult);
                checkTicket[i] = false;
            }
        }
    }
}
