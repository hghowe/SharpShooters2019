public class DieCollection
{
    private int[] myDice; // this will be my five dice. If I set one to zero, then that means it is "used."

    public DieCollection()
    {
        myDice = new int[5];
        randomizeAllDice();
    }

    /**
     * sets the given die to be "used" (i.e., 0).
     * @param which - the index of the die to set to used.
     */
    public void useDie(int which)
    {
        myDice[which] = 0;
    }

    /**
     * checks for the first die that has the same reading as the given value. If found, "uses" up that die and returns true.
     * If no matching dice are found, returns false.
     * @param value - the die value to search for.
     * @return - whether we found (and used) the given value on one die.
     */
    public boolean useDieWithValue(int value)
    {
        for (int i=0; i<5; i++)
        {
            if (myDice[i] == value)
            {
                useDie(i);
                return true;
            }
        }
        return false;
    }

    /**
     * indicates whether any of the five dice are nozero.
     * @return - true if there are any unused dice in the collection.
     */
    public boolean hasDiceLeft()
    {
        for (int d: myDice)
            if (d>0)
                return true;
        return false;
    }

    /**
     * rolls all five dice. each of myDice will now be a number 1-6, inclusive.
     */
    public void randomizeAllDice()
    {
        for (int i=0; i<5; i++)
            myDice[i] = 1;
        randomizeAllNonZeroDice();
    }

    /**
     * rolls only those dice in myDice that aren't already zero.
     */
    public void randomizeAllNonZeroDice()
    {
        for (int i=0; i<5; i++)
            if (myDice[i]>0)
                myDice[i] = (int)(Math.random()*6)+1;

    }


}
