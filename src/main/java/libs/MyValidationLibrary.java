package libs;

public final class MyValidationLibrary {
    public static final boolean isValidPesel(String s){
        if(s.length() != 11) {
            return false;
        }

        for(Character c : s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }

        return true;
    }

    public static final boolean isValidAge(String s){
        int i;
        try{
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return false;
        }

        if(i < 1 || i > 140) {
            return false;
        }

        return true;
    }
}
