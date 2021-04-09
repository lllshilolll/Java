public class Words {
    public static void main(String[] args) {
    String text = "Peasant Woman Binding Sheaves (after Millet) is an 1889 oil-on-canvas painting by Dutch " +
            "Post-Impressionist artist Vincent van Gogh showing a woman at work in a wheat field during the " +
            "harvest. As a young man, Van Gogh pursued what he saw as a religious calling, wanting to minister " +
            "to working people. Failing to find a vocation in ministry, he turned to art as a means of expressing " +
            "and communicating his deep sense of the meaning of life. In his series of paintings of wheat fields, " +
            "Van Gogh expressed through symbolism and use of colour his deeply felt spiritual beliefs, appreciation " +
            "of manual labourers, and connection to nature.";
        text = text.replaceAll("[!-/ - : - ? ]" , " ");
        String[] a = text.split(" ");
        int i = 0;
        while (i < a.length) {
            if ( a[i].equals("")){
                i++;
            }
            else {
                System.out.println(a[i]);
                i++;
            }

        }
}
}