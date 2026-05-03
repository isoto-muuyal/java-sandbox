package com.iss.learn;

public class EnumsTest {

    enum PizzaSize {
        SMALL, MEDIUM, LARGE;

        public String toString() {
            return "{ PizzaSize: " + this.name() + " }";
        }

        public static PizzaSize fromString(String pizzaSize) {
            return PizzaSize.valueOf(pizzaSize);
        }
    }

    public static void main(String[] args) {
        PizzaSize ps = PizzaSize.LARGE;
        System.out.println(ps);
        System.out.println(ps.name());
        System.out.println(ps.getClass().isInstance(PizzaSize.MEDIUM));
        System.out.println(ps.getClass().isEnum());

        PizzaSize ps2 = PizzaSize.fromString("MEDIUM");
        System.out.println(ps2);


        String word1 = "Willow", word2 = "ow";

        System.out.println(word1 == "Willow");
        System.out.println(word1 == ("Will" + "ow"));
        System.out.println(word1 == ("Will" + word2));

        String name = "Oliver";
        name.concat("Lawrence");
        //name = name.concat("Lawrence");
        String department = "Digital";

        System.out.println(name + department);

        String strOne = "Jonny";
        String strTwo = new String("Jonny");
        System.out.print(strOne.equals(strTwo));
        System.out.println(strOne == strTwo);

        StringBuilder sb = new StringBuilder("hello");
        sb.append(" there");
        System.out.println(sb);

        EnumsTest enumsTest = new EnumsTest();
        enumsTest.getName("sam", "roy");
    }

    public void getName(String fname, String lname) {
        String name = fname.concat(lname);
        StringBuilder sb = new StringBuilder(fname);
        //sb.append(" ");
        name = sb.toString();// Line 1
        System.out.println(name);

        String s1 = """
		            \""
		            """;
        String textBlock = """
                d-----
                sdf!!!!!""";
        String s2 = """
		            \"
		            """;

        String s3 = """
		            "
		            """;

        String s4 = """
			Text / Blocks
				""";

        System.out.println(textBlock);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
