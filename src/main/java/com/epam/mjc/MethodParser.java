package com.epam.mjc;

import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        ArrayList<String> strings = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(signatureString, " (,)");
        while (tokenizer.hasMoreTokens()){
            strings.add(tokenizer.nextToken());
        }

        boolean hasAccessModifier = true;
        if (!Objects.equals(strings.get(0), "protected")
                && !Objects.equals(strings.get(0), "public")
                && !Objects.equals(strings.get(0), "private")) {
            hasAccessModifier = false;
        }

        ArrayList <MethodSignature.Argument> arguments = new ArrayList<>();
        if(signatureString.indexOf("(")+1 != signatureString.indexOf(")")){
            System.out.println(strings.size());
            for(int i = hasAccessModifier ? 3 : 2; i<strings.size()-1; i+=2){
                System.out.println(arguments.toString());
                arguments.add(new MethodSignature.Argument(strings.get(i), strings.get(i+1)));
            }
        }

        System.out.println(arguments.toString());
        MethodSignature methodSignature;
        if(hasAccessModifier){
            methodSignature= new MethodSignature(strings.get(2), arguments);
            methodSignature.setAccessModifier(strings.get(0));
            methodSignature.setReturnType(strings.get(1));
        }else {
            methodSignature = new MethodSignature(strings.get(1),arguments);
            methodSignature.setReturnType(strings.get(0));
        }

        return methodSignature;
        //throw new UnsupportedOperationException("You should implement this method.");
    }
}
