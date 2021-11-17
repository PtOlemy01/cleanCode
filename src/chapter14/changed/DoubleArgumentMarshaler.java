package chapter14.changed;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static chapter14.changed.ArgsException.ErrorCode.*;

public class DoubleArgumentMarshaler implements ArgumentMarshaler{
    double doubleValue = 0.0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try{
            parameter = currentArgument.next();
            doubleValue = Double.parseDouble(parameter);
        }catch (NoSuchElementException e){
            throw new ArgsException(MISSING_DOUBLE);
        }catch (NumberFormatException e){
            throw new ArgsException(INVALID_DOUBLE, parameter);
        }
    }

    public static double getValue(ArgumentMarshaler am){
        if(am != null && am instanceof DoubleArgumentMarshaler)
            return ((DoubleArgumentMarshaler) am).doubleValue;
        else
            return 0.0;
    }
}
