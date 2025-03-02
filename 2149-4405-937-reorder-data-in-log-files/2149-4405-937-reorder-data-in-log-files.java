class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;

        List<String> letterLogs = new ArrayList<>();
        List<String>  digitLogs = new ArrayList<>();

        separateLogs(logs, letterLogs, digitLogs);
        sortLetterLogs(letterLogs);

        return combineLogs(letterLogs, digitLogs);
    }

    private String [] combineLogs(List<String> letterLogs, List<String> digitLogs){
        int length = letterLogs.size() + digitLogs.size();

        String [] result = new String[length];
        int index = 0;

        for(String log: letterLogs){
            result[index++] = log;
        }

        for(String log: digitLogs){
            result[index++] = log;
        }

        return result;
    }

    private void sortLetterLogs(List<String> letterLogs){
        Collections.sort(letterLogs, new Comparator<String>(){
            public int compare(String o1, String o2){
                String s1 = o1.substring(o1.indexOf(" ") + 1);
                String s2 = o2.substring(o2.indexOf(" ") + 1);

                return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
            }
        });
    }

    private void separateLogs(String [] logs, List<String> letterLogs, List<String> digitLogs){

        for(String log: logs){
            if(Character.isDigit(log.charAt(log.length()-1))){
                digitLogs.add(log);
            }
            else{
                letterLogs.add(log);
            }
        }
    }
}