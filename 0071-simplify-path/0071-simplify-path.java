class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        String [] paths = path.split("/");
        
        for(int i=0;i<paths.length;i++){
            String p = paths[i];
            if(p.equals("")){
                continue;
            }   
            else if(p.equals(".")){
                continue;
            }
            else if(p.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                //eg string = home
                stack.push(p);
            }
        }
        
        String result = "";
        
        while(!stack.isEmpty()){
            result = stack.pop() + "/" + result;
        }
        
        if(result.length() == 0){
            return "/";
        }
        
        return "/" + result.substring(0, result.length()-1);
    }
}