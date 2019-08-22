package com.saida_aliyeva.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Main3Activity extends AppCompatActivity {

    Button clearButton, divideButton, multipyButton, backSpaceButton,
            minusButton, plusButton, pointButton,
            plus_minusButton, equalButton,
            sevenButton, eightButton, nineButton, fourButton, fiveButton,
            sixButton, oneButton, twoButton, threeButton, zeroButton;
    EditText resultEditText;
    String[] arrayOperationSymbol = {"+", "-", "*", ":"};
    List<String> splitList = new ArrayList<>();
    int countOpenBracket = 0;
    int countClosedBracket = 0;
    boolean checkPlus_Minus = true;
    int countBtnEqual = 0;
    List<String> operation;
    List<String> values;
    List<String> splittedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViews();
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(oneButton.getText().toString());
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(twoButton.getText().toString());

            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(threeButton.getText().toString());
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(fourButton.getText().toString());


            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(fiveButton.getText().toString());
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(sixButton.getText().toString());

            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(sevenButton.getText().toString());

            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(eightButton.getText().toString());

            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(nineButton.getText().toString());
            }
        });


        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = resultEditText.getText().toString().trim();
                String buttonName = zeroButton.getText().toString();
                checkPlus_Minus = true;
                int len = inputText.length();
                if (!inputText.contains("=") && (!inputText.endsWith("+0") &&
                        !inputText.endsWith("-0") &&
                        !inputText.endsWith("*0") &&
                        !inputText.endsWith(":0"))
                        && (!inputText.equals("0"))
                ) {
                    resultEditText.append("0");

                }

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText("");
                countOpenBracket = 0;
                countClosedBracket = 0;
                checkPlus_Minus = true;

            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(plusButton.getText().toString());
                checkPlus_Minus = true;
            }
        });

        plus_minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = resultEditText.getText().toString().trim();
                String leftBracket = "(-";
                String rightBracket = ")";
                String result = "";
                String reverseText = "";
                StringBuilder sbInputText = new StringBuilder();
                int lenReverseText = 0;
                int lenReverseTextWithBracket = 0;
                int lenSubtract = 0;
                int len = inputText.length();
                if (len > 0) {
                    if (checkPlus_Minus) {
                        if (!inputText.contains("+") && !inputText.contains("-") && !inputText.contains(":") && !inputText.contains("*")
                                && !inputText.contains("=")) {
                            if (!inputText.endsWith(".") && !inputText.equals("0") && !inputText.startsWith("(")
                                    && !inputText.endsWith(")")) {
                                inputText = leftBracket.concat(inputText).concat(rightBracket);
                                resultEditText.setText(inputText);
                                checkPlus_Minus = false;

                            }
                        } else {
                            result = reverseAndSet(inputText);
                            StringBuilder inversedText = new StringBuilder(result);
                            inversedText = inversedText.reverse();
                            reverseText = String.valueOf(inversedText);
                            lenReverseText = reverseText.length();
                            if (!reverseText.equals("0")) {
                                reverseText = leftBracket.concat(reverseText).concat(rightBracket);
                                lenSubtract = len - lenReverseText;
                                lenReverseTextWithBracket = reverseText.length();
                                sbInputText.append(inputText);
                                if (!inputText.endsWith(".") && !inputText.endsWith("+")
                                        && !inputText.endsWith("-") && !inputText.endsWith("*")
                                        && !inputText.endsWith(":") && !inputText.endsWith("=") && !inputText.endsWith("(")
                                        && !inputText.endsWith(")")
                                        && !inputText.substring(lenSubtract - 2, lenSubtract).equals("(-")
                                ) {
                                    inputText = String.valueOf(sbInputText.replace(lenSubtract, len, reverseText));
                                    resultEditText.setText(inputText);
                                }
                                checkPlus_Minus = false;

                            } else {
                                checkPlus_Minus = true;
                            }
                        }
                    } else {
                        inputText = inputText.replace(inputText, inputText.substring(0, inputText.length() - 1));
                        resultEditText.setText(inputText);
                        inputText = resultEditText.getText().toString().trim();
                        len = inputText.length();
                        result = reverseAndSet(inputText);
                        StringBuilder inversedText = new StringBuilder(result);
                        inversedText = inversedText.reverse();
                        reverseText = String.valueOf(inversedText);
                        lenReverseText = reverseText.length();
                        lenSubtract = len - lenReverseText;
                        sbInputText.append(inputText);
                        inputText = String.valueOf(sbInputText.replace(lenSubtract - 2, len, reverseText));
                        resultEditText.setText(inputText);
                        checkPlus_Minus = true;
                    }


                }
            }
        });


        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(minusButton.getText().toString());
                checkPlus_Minus = true;

            }
        });
        multipyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(multipyButton.getText().toString());
                checkPlus_Minus = true;

            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(divideButton.getText().toString());

                checkPlus_Minus = true;

            }
        });
        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = resultEditText.getText().toString();
                int len = getText.length();
                if (len > 0) {
                    makeArray(getText);
                    if (!splitList.get(splitList.size() - 1).contains(".")
                            && !String.valueOf(getText.charAt(len - 1)).equals("+")
                            && !String.valueOf(getText.charAt(len - 1)).equals("-")
                            && !String.valueOf(getText.charAt(len - 1)).equals("*")
                            && !String.valueOf(getText.charAt(len - 1)).equals(":")
                            && !String.valueOf(getText.charAt(len - 1)).equals("(")
                            && !String.valueOf(getText.charAt(len - 1)).equals(")")
                            && !String.valueOf(getText.charAt(len - 1)).equals("=")) {
                        resultEditText.append(pointButton.getText().toString());


                    }
                }

            }


        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countBtnEqual = 1;
                String text = resultEditText.getText().toString().trim();
                int len = text.length();
                checkLastSymbol(equalButton.getText().toString());
                len = resultEditText.getText().toString().trim().length();
                if (String.valueOf(resultEditText.getText().toString().trim().charAt(len - 1)).equals("=")) {
                    splitText(text);
                }


            }


        });
        backSpaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPlus_Minus = true;
                String lastSymbol;
                String text = resultEditText.getText().toString();
                int len = resultEditText.getText().toString().trim().length();
                if (len > 0) {
                    lastSymbol = String.valueOf(resultEditText.getText().toString().trim().charAt(len - 1));
                    text = text.substring(0, text.length() - 1);
                    resultEditText.setText(text);
                    resultEditText.setSelection(text.length());

                }

            }
        });

    }


    public void checkLastSymbol(String buttonName) {
        int len = resultEditText.getText().length();
        String getText = resultEditText.getText().toString().trim();
        if (len > 0
                && !String.valueOf(getText.charAt(len - 1)).equals("+")
                && !String.valueOf(getText.charAt(len - 1)).equals("-")
                && !String.valueOf(getText.charAt(len - 1)).equals("*")
                && !String.valueOf(getText.charAt(len - 1)).equals(":")
                && !getText.contains("=")) {

            resultEditText.append(buttonName);

        }

    }

    public void appendButtonName(String buttonName) {
        String inputText = resultEditText.getText().toString().trim();
        int len = inputText.length();
        if (len == 0 || !inputText.contains("=") && (!inputText.endsWith("(") &&
                !inputText.endsWith(")"))) {
            resultEditText.append(buttonName);
            checkPlus_Minus = true;

        }
    }


    public void addOperationToList(String text) {
        // texti operationlara bolur ve  liste yigir
        operation = new ArrayList<>();
        if (text.length() > 0) {
            for (int i = 0; i < text.length(); i++) {
                if ((String.valueOf(text.charAt(i)).equals("+")
                        || String.valueOf(text.charAt(i)).equals("-"))
                        && !String.valueOf(text.charAt(i)).equals("=")) {
                    operation.add(String.valueOf(text.charAt(i)));

                }
            }
        }

    }


    public void splitText(String text) {
        // texti yalniz + ve - gore split edir
        splittedText = new ArrayList<>();
        String[] arrayByPlus = text.split(Pattern.quote("+"));

        String result;
        for (int i = 0; i < arrayByPlus.length; i++) {
            if (arrayByPlus[i].contains("-")) {
                if (arrayByPlus[i].contains("(-")) {
                    String str = Pattern.quote("(-");
                    arrayByPlus[i].replaceAll(str, "");
                    arrayByPlus[i] = arrayByPlus[i].replace("(-", "");
                    Log.e("arrayByPlus[i]", arrayByPlus[i]);
                    String[] arrayByMinus = arrayByPlus[i].split("-");
                    for (int j = 0; j < arrayByMinus.length; j++) {
                        if (!arrayByMinus[j].contains("*") && !arrayByMinus[j].contains(":")) {
                            splittedText.add(String.valueOf(arrayByMinus[j]));
                            Log.e("arrayByMinus[j]", arrayByMinus[j]);
                        } else {
                            splittedText.add(String.valueOf(arrayByMinus[j]));
                        }
                    }
                } else {
                    String[] arrayByMinus2 = arrayByPlus[i].split("-");
                    for (int j = 0; j < arrayByMinus2.length; j++) {
                        if (!arrayByMinus2[j].contains("*") && !arrayByMinus2[j].contains(":")) {
                            splittedText.add(String.valueOf(arrayByMinus2[j]));
                            Log.e("arrayByMinus[j]", arrayByMinus2[j]);
                        } else {
                            splittedText.add(String.valueOf(arrayByMinus2[j]));
                        }
                    }
                }

            } else {
                splittedText.add(arrayByPlus[i]);
            }
            Log.e("splittedText", String.valueOf(splittedText));
        }
        for (int i = 0; i < splittedText.size(); i++) {
            if (splittedText.get(i).contains("*") || splittedText.get(i).contains(":")) {
                addValueToList(splittedText.get(i));
                result = calculateOnlyMultipyAndDivide(text);
                splittedText.set(i, result);

            }
        }
        if (text.contains(":0")) {
            resultEditText.append("invalid operation");
        } else {
            if (text.contains("(-")) {
                text = text.replaceAll(Pattern.quote("(-"), "");
                addOperationToList(text);
            } else {
                addOperationToList(text);

            }
            calculateOnlySumAndSubtract();

        }


    }

    public void addValueToList(String text) {
        // texti ededlere  bolur ve  liste yigir
        String value = "";
        values = new ArrayList<>();
        operation = new ArrayList<>();
        if (text.length() > 0) {
            for (int i = 0; i < text.length(); i++) {
                if (!String.valueOf(text.charAt(i)).equals("*") && !String.valueOf(text.charAt(i)).equals(":")) {
                    value = value + text.charAt(i);
                    if (text.endsWith(value)) {
                        values.add(value);
                    }

                } else {
                    values.add(value);
                    value = "";
                    if (!String.valueOf(text.charAt(i)).equals("=")) {
                        operation.add(String.valueOf(text.charAt(i)));
                    }
                }
            }
        }
    }


    public String calculateOnlyMultipyAndDivide(String text) {
        boolean checkNeqative = false;
        String resultCheck = "";
        String op;
        double res = 0;
        Iterator<String> iterator = operation.iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i).contains(")")) {
                    values.set(i, convertToNegative(values.get(i)));
                }
            }
            op = String.valueOf(iterator.next());
            if (op.equals("*")) {
                res = Double.parseDouble(values.get(0)) * Double.parseDouble(values.get(1));
                values.remove(0);
                values.remove(0);
                values.add(0, String.valueOf(res));

            }
            if (op.equals(":")) {
                res = Double.parseDouble(values.get(0)) / Double.parseDouble(values.get(1));
                Log.e("res/", String.valueOf(res));
                values.remove(0);
                values.remove(0);
                values.add(0, String.valueOf(res));
            }
        }
        resultCheck = String.valueOf(res);
        checkNeqative = checkNeqative(text);

        if (!text.contains("+")) {
            if (!text.contains("-")) {
                resultEditText.append(resultCheck);
            } else if (checkNeqative) {
                boolean chek = checkNeqative(text);
                resultEditText.append(resultCheck);
            }
        }
        return resultCheck;

    }

    public boolean checkNeqative(String text) {
        // simvolun menfi (-) yaxud cixma isaresi oldugunu yoxlayir
        boolean checkNeqative = false;
        if (text.contains("-")) {
            int index = text.indexOf("-");
            if (String.valueOf(text.charAt(index - 1)).equals("(")) {
                checkNeqative = true;
            } else checkNeqative = false;
        }
        return checkNeqative;
    }


    public String convertToNegative(String text) {
        String str3 = text.substring(0, text.length() - 1);
        String str4 = "-".concat(str3);
        return str4;
    }


    public void calculateOnlySumAndSubtract() {
        String op;
        double res = 0;
        for (int i = 0; i < splittedText.size(); i++) {
            if (splittedText.get(i).contains(")")) {
                splittedText.set(i, convertToNegative(splittedText.get(i)));
            }
        }
        Iterator<String> iterator = operation.iterator();
        while (iterator.hasNext()) {
            op = String.valueOf(iterator.next());
            if (!operation.equals("*") && !operation.equals(":")) {
                if (op.equals("+")) {
                    res = Double.parseDouble(splittedText.get(0)) + Double.parseDouble(splittedText.get(1));
                    splittedText.remove(0);
                    splittedText.remove(0);
                    splittedText.add(0, String.valueOf(res));

                }
                if (op.equals("-")) {
                    res = Double.parseDouble(splittedText.get(0)) - Double.parseDouble(splittedText.get(1));
                    splittedText.remove(0);
                    splittedText.remove(0);
                    splittedText.add(0, String.valueOf(res));
                }
            }
        }
        resultEditText.append(String.format("%.3f", res));

    }


    public void makeArray(String text) {
        String[] array;
        int count = 0;
        for (int i = 0; i < arrayOperationSymbol.length; i++) {
            if (text.contains(arrayOperationSymbol[i])) {
                array = text.split(Pattern.quote(arrayOperationSymbol[i]));
                for (String s : array) {
                    text = s;
                    makeArray(text);

                }
            } else {
                count++;
            }
            if (count == 4) {
                splitList.add(text);

            }
        }

    }

    public String reverseAndSet(String inputText) {
        String result = "";
        int len = inputText.length();
        int i = 1;
        String lastSymbol2 = String.valueOf(inputText.charAt(len - 1));
        while (!lastSymbol2.equals("+") && !lastSymbol2.equals("-") &&
                !lastSymbol2.equals("*") && !lastSymbol2.equals(":") &&
                !lastSymbol2.equals("=") && !lastSymbol2.equals("(") &&
                !lastSymbol2.equals(")")
        ) {
            result = result.concat(lastSymbol2);
            i++;
            if (len > i) {
                lastSymbol2 = String.valueOf(inputText.charAt(len - i));
            }

        }
        return result;
    }


    public static double round(double value, int places) {
        // yuvarlaqlasdirma
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void initViews() {
        resultEditText = findViewById(R.id.result);
        clearButton = findViewById(R.id.clear);
        backSpaceButton = findViewById(R.id.backSpace);
        divideButton = findViewById(R.id.divide);
        multipyButton = findViewById(R.id.multipy);
        minusButton = findViewById(R.id.minus);
        plusButton = findViewById(R.id.plus);
        pointButton = findViewById(R.id.point);
        plus_minusButton = findViewById(R.id.plus_minus);
        equalButton = findViewById(R.id.equal);
        sevenButton = findViewById(R.id.seven);
        eightButton = findViewById(R.id.eight);
        nineButton = findViewById(R.id.nine);
        fourButton = findViewById(R.id.four);
        fiveButton = findViewById(R.id.five);
        sixButton = findViewById(R.id.six);
        threeButton = findViewById(R.id.three);
        twoButton = findViewById(R.id.two);
        oneButton = findViewById(R.id.one);
        zeroButton = findViewById(R.id.zero);

    }
}



