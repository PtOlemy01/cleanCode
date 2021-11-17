package chapter14.changed;

import java.util.Iterator;

public class StringArrayArgumentMashaler implements ArgumentMarshaler {
    String[] stringArrayValue = null;
    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {

    }

    public static String[] getValue(ArgumentMarshaler am){
        if(am != null && am instanceof StringArrayArgumentMashaler)
            return ((StringArrayArgumentMashaler)am).stringArrayValue;
        else
            return null;
    }
}
