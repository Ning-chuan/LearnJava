public class Student {
    private String name;
    private String password;
    public Student(String name,String password){
        this.name = name;
        this.password = password;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
//    //考试方法：
//    public String[] exam(ArrayList<Question> paper){
//        String[] answers = new String[paper.size()];
//        Scanner input = new Scanner(System.in);
//        for(int i=0;i<paper.size();i++){
//            System.out.println(paper.get(i).getTitle());
//            System.out.println("请输入您认为正确的答案：");
//            answers[i] = input.nextLine();
//        }
//        return answers;
//    }
}
