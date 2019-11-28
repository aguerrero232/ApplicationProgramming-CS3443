package edu.utsa.cs3443.lab2.test;
import edu.utsa.cs3443.lab2.BigInteger;
import org.junit.Assert;

public class BigIntegerTest {

    BigInteger bigInteger;
    BigInteger bigInteger1;
    BigInteger bigInteger2;
    BigInteger bigInteger3;
    BigInteger bigInteger4;
    BigInteger bigIntegerFail;

    @org.junit.Before
    public void setUp() throws Exception {
        bigInteger = new BigInteger("1");
        bigInteger1 = new BigInteger("0");
        bigInteger2 = new BigInteger("2");
        bigInteger3 = new BigInteger("10");
        bigInteger4 = new BigInteger("100000000000000000000000000000000000000000000");
        bigIntegerFail = new BigInteger("Fail");
        System.out.print("TESTING .....");
    }

    @org.junit.Test
    public void setBigInteger() {
        bigInteger.setBigInteger(30);
        bigInteger2.setBigInteger("Number");
        bigInteger3.setBigInteger('N');

        Assert.assertEquals(bigInteger.compareTo(new BigInteger(30)),0);
        Assert.assertEquals(bigInteger2.compareTo(new BigInteger("Number")),0);
        Assert.assertEquals(bigInteger3.compareTo(new BigInteger('N')),0);

    }

    @org.junit.Test
    public void add() {
        Assert.assertEquals(bigInteger.add(bigInteger2).toString(),"3");
        Assert.assertEquals(bigInteger.add(bigInteger3).toString(),"11");
        Assert.assertEquals(bigInteger2.add(bigInteger3).toString(),"12");
        Assert.assertEquals(bigInteger3.add(bigInteger3).toString(),"20");
        Assert.assertEquals(bigInteger.add(bigInteger4).toString(),"100000000000000000000000000000000000000000001");
        Assert.assertEquals(bigInteger3.add(bigInteger4).toString(),"100000000000000000000000000000000000000000010");
//        assertEquals(bigInteger.add(bigIntegerFailCase).toString(),"value");
    }

    @org.junit.Test
    public void increment() {
        Assert.assertEquals(bigInteger.increment().toString(),"2");
        Assert.assertEquals(bigInteger4.increment().toString(),"100000000000000000000000000000000000000000001");
        Assert.assertEquals(bigInteger2.increment().toString(),"3");
        Assert.assertEquals(bigInteger3.increment().toString(),"11");
        //        assertEquals(bigInteger.increment(bigIntegerFailCase).toString(),"value");
    }

    @org.junit.Test
    public void multiply() {
        Assert.assertEquals(bigInteger.multiply(bigInteger2).toString(),"2");
        Assert.assertEquals(bigInteger.multiply(bigInteger3).toString(),"10");
        Assert.assertEquals(bigInteger.multiply(bigInteger4).toString(),"100000000000000000000000000000000000000000000");
        Assert.assertEquals(bigInteger.multiply(bigInteger1).toString(),"0");
        //        assertEquals(bigInteger.multiply(bigIntegerFailCase).toString(),"value");
    }

    @org.junit.Test
    public void compareTo() {
        Assert.assertEquals(bigInteger2.compareTo(bigInteger2),0);
        Assert.assertEquals(bigInteger3.compareTo(bigInteger3),0);
        Assert.assertEquals(bigInteger4.compareTo(bigInteger),1);
        Assert.assertEquals(bigInteger3.compareTo(bigInteger4),-1);
        //        assertEquals(bigInteger.compareTo(bigIntegerFailCase),"value");
    }
}