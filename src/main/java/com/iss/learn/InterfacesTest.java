package com.iss.learn;

import com.iss.learn.enums.MyEnum;
import com.iss.learn.interfaces.IntA;
import com.iss.learn.interfaces.IntB;
import com.iss.learn.myobjects.Book;
import com.iss.learn.myobjects.BookRecord;

import java.util.function.Function;

public class InterfacesTest implements IntA, IntB {

    public static void main(String[] args) {
        InterfacesTest interfacesTest = new InterfacesTest();
        interfacesTest.disp();
        System.out.println(IntA.x);
        System.out.println(IntB.x);

        Book book1 = IntB.book1;
        book1.setAuthor("pepeß");
        BookRecord book2 = new BookRecord(1, "hola");

        System.out.println(book1.getName());
        System.out.println(book2);

        System.out.println(MyEnum.AB);
        System.out.println(MyEnum.AB.name());
        System.out.println(MyEnum.AC);
        System.out.println(MyEnum.AC.ordinal());
        System.out.println(MyEnum.AD);
        System.out.println(MyEnum.AD.getBook());

        Function<String, String> myfirstFunc = st -> st.substring(0,st.length());
        myfirstFunc = myfirstFunc.andThen(String::toUpperCase);
        myfirstFunc = myfirstFunc.compose(s -> "other string"  + s);
        Function<String, String> i = Function.identity();
        System.out.println(myfirstFunc.apply("hello world"));
        System.out.println(i.apply("10"));

        Function<Integer, Integer> doubleIt = in -> in + in;
        Function<Integer, Integer> squareIt = in -> in*in;
        squareIt = squareIt.compose( s1 ->  s1 - 1);
        Function<Integer, Integer> res = doubleIt.andThen(squareIt);
        System.out.println(res.apply(5));

        Function<Integer, Integer> addFive = a -> a + 5;
        Function<Integer, Integer> multiplyByTwo = a -> a * 2;
        // Applying functions sequentially: Add five, then multiply by two
        Function<Integer, Integer> result = addFive.andThen(multiplyByTwo);
        System.out.println(result.apply(3));

    }

    @Override
    public void disp() {
        IntA.super.disp();
        IntB.super.disp();
        System.out.println("disp in test");
    }
}
