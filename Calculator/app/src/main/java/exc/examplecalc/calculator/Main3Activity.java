package exc.examplecalc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.contactswhatsapp.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Main3Activity extends AppCompatActivity {

    Button btnClear, btnDivide, btnMultiPy, btnBackSpace,
            btnMinus, btnPlus, btnPoint,
            btnPlus_Minus, btnEqual,
            btnSeven, btnEight, btnNine, btnFour, btnFive, btnSix, btnOne, btnTwo, btnThree, btnZero;
    EditText edtResult;
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
        edtResult = findViewById(R.id.result);
        btnClear = findViewById(R.id.clear);
        btnBackSpace = findViewById(R.id.backSpace);
        btnDivide = findViewById(R.id.divide);
        btnMultiPy = findViewById(R.id.multipy);
        btnMinus = findViewById(R.id.minus);
        btnPlus = findViewById(R.id.plus);
        btnPoint = findViewById(R.id.point);
        btnPlus_Minus = findViewById(R.id.plus_minus);
        btnEqual = findViewById(R.id.equal);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);
        btnFour = findViewById(R.id.four);
        btnFive = findViewById(R.id.five);
        btnSix = findViewById(R.id.six);
        btnThree = findViewById(R.id.three);
        btnTwo = findViewById(R.id.two);
        btnOne = findViewById(R.id.one);
        btnZero = findViewById(R.id.zero);


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnOne.getText().toString());


            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnTwo.getText().toString());

            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnThree.getText().toString());
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnFour.getText().toString());


            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnFive.getText().toString());


            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnSix.getText().toString());


            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnSeven.getText().toString());


            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnEight.getText().toString());

            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendButtonName(btnNine.getText().toString());


            }
        });


        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = edtResult.getText().toString().trim();
                String buttonName = btnZero.getText().toString();
                checkPlus_Minus = true;
                int len = inputText.length();
                if (!inputText.contains("=") && (!inputText.endsWith("+0") &&
                        !inputText.endsWith("-0") &&
                        !inputText.endsWith("*0") &&
                        !inputText.endsWith(":0"))
                        && (!inputText.equals("0"))
                ) {
                    edtResult.append("0");

                }

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtResult.setText("");
                countOpenBracket = 0;
                countClosedBracket = 0;
                checkPlus_Minus = true;

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnPlus.getText().toString());
                checkPlus_Minus = true;
            }
        });

        btnPlus_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = edtResult.getText().toString().trim();
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
                                edtResult.setText(inputText);
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
                                    edtResult.setText(inputText);
                                }
                                checkPlus_Minus = false;

                            } else {
                                checkPlus_Minus = true;
                            }
                        }
                    } else {
                        inputText = inputText.replace(inputText, inputText.substring(0, inputText.length() - 1));
                        edtResult.setText(inputText);
                        inputText = edtResult.getText().toString().trim();
                        len = inputText.length();
                        result = reverseAndSet(inputText);
                        StringBuilder inversedText = new StringBuilder(result);
                        inversedText = inversedText.reverse();
                        reverseText = String.valueOf(inversedText);
                        lenReverseText = reverseText.length();
                        lenSubtract = len - lenReverseText;
                        sbInputText.append(inputText);
                        inputText = String.valueOf(sbInputText.replace(lenSubtract - 2, len, reverseText));
                        edtResult.setText(inputText);
                        checkPlus_Minus = true;
                    }


                }
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnMinus.getText().toString());
                checkPlus_Minus = true;

            }
        });
        btnMultiPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnMultiPy.getText().toString());
                checkPlus_Minus = true;

            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnDivide.getText().toString());

                checkPlus_Minus = true;

            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = edtResult.getText().toString();
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
                        edtResult.append(btnPoint.getText().toString());


                    }
                }

            }


        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countBtnEqual = 1;
                String text = edtResult.getText().toString().trim();
                int len = text.length();
                checkLastSymbol(btnEqual.getText().toString());
                len = edtResult.getText().toString().trim().length();
                if (String.valueOf(edtResult.getText().toString().trim().charAt(len - 1)).equals("=")) {
                    splitText(text);
                }


            }


        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPlus_Minus = true;
                String lastSymbol;
                String text = edtResult.getText().toString();
                int len = edtResult.getText().toString().trim().length();
                if (len > 0) {
                    lastSymbol = String.valueOf(edtResult.getText().toString().trim().charAt(len - 1));
                    text = text.substring(0, text.length() - 1);
                    edtResult.setText(text);
                    edtResult.setSelection(text.length());

                }

            }
        });

    }


    public void checkLastSymbol(String buttonName) {
        int len = edtResult.getText().length();
        String getText = edtResult.getText().toString().trim();
        if (len > 0
                && !String.valueOf(getText.charAt(len - 1)).equals("+")
                && !String.valueOf(getText.charAt(len - 1)).equals("-")
                && !String.valueOf(getText.charAt(len - 1)).equals("*")
                && !String.valueOf(getText.charAt(len - 1)).equals(":")
                && !getText.contains("=")) {

            edtResult.append(buttonName);

        }

    }

    public void appendButtonName(String buttonName) {
        String inputText = edtResult.getText().toString().trim();
        int len = inputText.length();
        if (len == 0 || !inputText.contains("=") && (!inputText.endsWith("(") &&
                !inputText.endsWith(")"))) {
            edtResult.append(buttonName);
            checkPlus_Minus = true;

        }
    }


    public void addOperationToList(String text) {
        // texti operationlara bolur ve  liste yigir
        Log.e("calledMethod", "addOperationToList3");
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
            edtResult.append("invalid operation");
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
        Log.e("calledMethod", "addValueToList");
        Log.e("text", text);
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
                    Log.e("valueAdd", value.toString());
                    value = "";
                    if (!String.valueOf(text.charAt(i)).equals("=")) {
                        operation.add(String.valueOf(text.charAt(i)));
                    }
                    Log.e("value=", value);
                    Log.e("operation=", String.valueOf(operation));
                }
            }
            Log.e("values", String.valueOf(values));
        }
    }


    public String calculateOnlyMultipyAndDivide(String text) {
        boolean checkNeqative = false;
        String resultCheck = "";
        Log.e("calledMethod", "check");
        String op;
        double res = 0;
        Iterator<String> iterator = operation.iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i).contains(")")) {
                    values.set(i, convertToNegative(values.get(i)));
                    Log.e("resValues", values.get(i));
                }
            }
            op = String.valueOf(iterator.next());
            if (op.equals("*")) {
                res = Double.parseDouble(values.get(0)) * Double.parseDouble(values.get(1));
                Log.e("res*", String.valueOf(res));
                values.remove(0);
                values.remove(0);
                values.add(0, String.valueOf(res));

            }
            if (op.equals(":")) {
                Log.e("valueCalc:", values.get(0));
                res = Double.parseDouble(values.get(0)) / Double.parseDouble(values.get(1));
                Log.e("res/", String.valueOf(res));
                values.remove(0);
                values.remove(0);
                values.add(0, String.valueOf(res));
            }
        }
        Log.e("checkResult-", String.valueOf(res));
        resultCheck = String.valueOf(res);
        checkNeqative = checkNeqative(text);
        Log.e("checkNeqative-", String.valueOf(checkNeqative));
        Log.e("cheText-", text);

        if (!text.contains("+")) {
            if (!text.contains("-")) {
                edtResult.append(resultCheck);
            } else if (checkNeqative) {
                Log.e("checkResultText-", text);
                boolean chek = checkNeqative(text);
                Log.e("chek", String.valueOf(checkNeqative));
                edtResult.append(resultCheck);
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
        Log.e("calledMethod", "check");
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
                    Log.e("res+", String.valueOf(res));
                    splittedText.remove(0);
                    splittedText.remove(0);
                    splittedText.add(0, String.valueOf(res));

                }
                if (op.equals("-")) {
                    res = Double.parseDouble(splittedText.get(0)) - Double.parseDouble(splittedText.get(1));
//                    Log.e("res-", String.valueOf(res));
                    splittedText.remove(0);
                    splittedText.remove(0);
                    splittedText.add(0, String.valueOf(res));
                }
            }
        }

        edtResult.append(String.format("%.3f", res));

    }


    public String getLastNumberFromText(String inputText) {
        Log.e("called", "getLastNumberFromText");
        int i = 1;
        String result = "";
        String lastSymbol = "";
        int len = inputText.length();
        if (len > 0) {
            lastSymbol = String.valueOf(inputText.charAt(inputText.length() - 1));
            while (!lastSymbol.equals("+") && !lastSymbol.equals("-") && !lastSymbol.equals("*") && !lastSymbol.equals(":")
                    && !inputText.endsWith(".") && !lastSymbol.equals("=")) {
                result = result.concat(lastSymbol);
                i++;
                lastSymbol = String.valueOf(inputText.charAt(inputText.length() - i));

            }
        }
        return result;

    }


    public String inverseText(String lastSymbol) {
        Log.e("called", "inverseText");

        String textInverse = "";

        for (int j = 1; j < lastSymbol.length() + 1; j++) {
            textInverse = textInverse.concat(String.valueOf(lastSymbol.charAt(lastSymbol.length() - j)));
            Log.e("logtextInverse", textInverse);


        }

        return textInverse;
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
        String reverseText = "";
        int lenReverseText = 0;

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
}



