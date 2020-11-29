package at.nsc.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *  Übung 9 - Model
 * @author Niklas Schachl
 * @version 1.0, 29.11.2020
 */
public class model_8ballData
{
    private ArrayList<String> list_answers = new ArrayList<String>();

    public model_8ballData()
    {
        list_answers.add("It is certain");
        list_answers.add("It is decidedly so");
        list_answers.add("Without a doubt");
        list_answers.add("Yes – definitely");
        list_answers.add("You may rely on it");
        list_answers.add("As I see it, yes");
        list_answers.add("Most likely");
        list_answers.add("Outlook good");
        list_answers.add("Signs point to yes");
        list_answers.add("Yes");

        list_answers.add("Reply hazy, try again");
        list_answers.add("Ask again later");
        list_answers.add("Better not tell you now");
        list_answers.add("Cannot predict now");
        list_answers.add("Concentrate and ask again");

        list_answers.add("Don’t count on it");
        list_answers.add("My reply is no");
        list_answers.add("My sources say no");
        list_answers.add("Outlook not so good");
        list_answers.add("Very doubtful");
    }

    public String getAnswer()
    {
        Random rd = new Random();

        return list_answers.get(rd.nextInt(list_answers.size()));
    }
}
