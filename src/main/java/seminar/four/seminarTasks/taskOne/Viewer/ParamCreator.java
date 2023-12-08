package seminar.four.seminarTasks.taskOne.Viewer;

import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParamCreator extends AbstractParams {

    private final BufferedReader reader;

    public ParamCreator(BufferedReader reader){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public String getLogin(String type) throws IOException {
        try {
            System.out.println("Please enter your" + type + ": " );
            return reader.readLine();
        }catch (IOException ex){
            System.out.println("Something went wrong with" + type + "please, try again");
            reader.readLine();
        }
        return null;
    }

    @Override
    public String getPassword(String type) throws IOException {
        try {
            System.out.println("Please enter your" + type + ": ");
            return reader.readLine();
        }catch (IOException ex){
            System.out.println("Something went wrong with" + type + "please, try again");
            reader.readLine();
        }
        return null;
    }
}
