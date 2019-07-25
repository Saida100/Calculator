package exc.examplecalc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactswhatsapp.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
    Button btnClear, btnDivide, btnMultiPy, btnBackSpace,
            btnMinus, btnPlus, btnBracket, btnPoint,
            btnPlus_Minus, btnEqual,
            btnSeven, btnEight, btnNine, btnFour, btnFive, btnSix, btnOne, btnTwo, btnThree, btnZero;
    EditText edtResult;
    String getText = "";
    String[] arrayOperationSymbol = {"+", "-", "*", ":"};
    List<String> splitList = new ArrayList<>();
    int countOpenBracket = 0;
    int countClosedBracket = 0;
    boolean checkPlus_Minus = true;
    String lastText;
    List<String> bracketTextList = new ArrayList<>();
    int countBtnEqual = 0;
    List<String> operation;
    List<String> values;
    List<String> splittedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edtResult = findViewById(R.id.result);
        btnClear = findViewById(R.id.clear);
        btnBackSpace = findViewById(R.id.backSpace);
        btnDivide = findViewById(R.id.divide);
        btnMultiPy = findViewById(R.id.multipy);
        btnMinus = findViewById(R.id.minus);
        btnPlus = findViewById(R.id.plus);
        btnBracket = findViewById(R.id.bracket);
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
                String getText = edtResult.getText().toString().trim();
                String buttonName = btnZero.getText().toString();
                int len = getText.length();
                if (!getText.contains("=") && (!getText.endsWith("+0") &&
                        !getText.endsWith("-0") &&
                        !getText.endsWith("*0") &&
                        !getText.endsWith(":0"))
                        && (!getText.equals("0"))
                    // || ( getText.startsWith("0") && !getText.substring(1, 2).equals("0"))
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

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnPlus.getText().toString());


            }
        });


        btnPlus_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = edtResult.getText().toString().trim();
                Log.e("inputTextTTT",inputText);
                String result="" ;
                String inversedText;
                StringBuilder inputTextBeforeReplace=new StringBuilder(inputText);
                StringBuilder inputTextAfterReplace=null;
                int len=inputTextBeforeReplace.length();
                if(!inputText.contains("+") && !inputText.contains("-") &&!inputText.contains("*") && !inputText.contains(":")
                        && !inputText.contains("=") ){
                    inversedText=inputText;
                    Log.e("inverst",inversedText);
                    Log.e("inputText",inputText);

                } else {
                     result = getLastNumberFromText(inputText);
                     inversedText=inverseText(result);
                    Log.e("inputInvBefore",inversedText);
                }
                if(checkPlus_Minus){
                    Log.e("inputTrueOlanda", String.valueOf(checkPlus_Minus));

                    int index=inputText.length()-inversedText.length();
                    inputTextAfterReplace= inputTextBeforeReplace.replace(index,len,"(-"+inversedText+")");
                    edtResult.setText(inputTextAfterReplace);
                    if(len!=inputTextBeforeReplace.length()){
                        checkPlus_Minus=false;
                    }
                    Log.e("input", String.valueOf(checkPlus_Minus));

                } else{
                    Log.e("inputFalseOlanda", String.valueOf(checkPlus_Minus));
                    inputText=inputText.replace(inputText,inputText.substring(0,inputText.length()-1));
                    edtResult.setText(inputText);
                    Log.e("inputTextAfter",inputText);
                    result = getLastNumberFromText(inputText);
                    inversedText=inverseText(result);
                    Log.e("inputInvAfter",result);
                    Log.e("inputInvAfter",inversedText);
                    int len2=inversedText.length();
                    Log.e("inputInvAfterLen2", String.valueOf(len2));
                    inputText=inputText.substring(0,inputText.length()-(len2+2)).concat(inversedText);
                    Log.e("inputInvAfterLast",inputText);
                    edtResult.setText(inputText);
                    Log.e("inpAfter/builder", String.valueOf(inputTextAfterReplace));
                      if(len==inputTextBeforeReplace.length()){
                          checkPlus_Minus=true;
                      }
                    Log.e("inputFalseOlanda", String.valueOf(checkPlus_Minus));


                }

            }
        });





        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnMinus.getText().toString());

            }
        });
        btnMultiPy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnMultiPy.getText().toString());

            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLastSymbol(btnDivide.getText().toString());


            }
        });
        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int len = getText.length();
                String text = edtResult.getText().toString();
                if (len == 0) {
                    countOpenBracket = 0;
                    countClosedBracket = 0;
                    edtResult.append("(");
                    countOpenBracket++;
                    System.out.println("countOpenBracket=" + countOpenBracket);

                }
                if (len > 0) {

                    if (String.valueOf(text.charAt(len - 1)).equals("(")
                            || String.valueOf(text.charAt(len - 1)).equals("+")
                            || String.valueOf(text.charAt(len - 1)).equals("-")
                            || String.valueOf(text.charAt(len - 1)).equals("*")
                            || String.valueOf(text.charAt(len - 1)).equals(":")) {
                        edtResult.append("(");
                        countOpenBracket++;
                        System.out.println("countOpenBracket=" + countOpenBracket);

                    } else if (countOpenBracket > countClosedBracket) {
                        edtResult.append(")");
                        countClosedBracket++;
                        System.out.println("countClosedBracket=" + countClosedBracket);
                    }
                    if (String.valueOf(text.charAt(len - 1)).equals("(") && checkPlus_Minus == false) {
                        edtResult.setSelection(0);
                        edtResult.append(")");
                        countClosedBracket++;
                        System.out.println("countClosedBracket=" + countClosedBracket);
                    }

                }

            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = edtResult.getText().toString();
                System.out.println("getText=" + edtResult.getText().toString());
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
                        System.out.println("Lasttext=" + edtResult.getText().toString());
                        System.out.println("len=" + len);

                        System.out.println("last simvol of text=" + getText.charAt(len - 1));

                    }
                }

            }


        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countBtnEqual = 1;
                String text = edtResult.getText().toString().trim();
                Log.e("log", text);
                int len = text.length();
                checkLastSymbol(btnEqual.getText().toString());
                Log.e("log", edtResult.getText().toString().trim());
                Log.e("log", String.valueOf(edtResult.getText().toString().trim().charAt(len - 1)));
                len = edtResult.getText().toString().trim().length();
                if (String.valueOf(edtResult.getText().toString().trim().charAt(len - 1)).equals("=")) {
                    //  calculateSameOperation(text);
                    splitText(text);
                }


            }


        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastSymbol;
                String text = edtResult.getText().toString();
                int len = edtResult.getText().toString().trim().length();
                if (len > 0) {
                    lastSymbol = String.valueOf(edtResult.getText().toString().trim().charAt(len - 1));
                    if (lastSymbol.equals("(")) {
                        countOpenBracket--;
                    }
                    if (lastSymbol.equals(")")) {
                        countClosedBracket--;
                    }

                    text = text.substring(0, text.length() - 1);
                    edtResult.setText(text);
                    edtResult.setSelection(text.length());

                }

            }
        });

    }

    public void replaceSymbol(String symbol) {
        String getText = edtResult.getText().toString().trim();
        int len = getText.length();
        String text = getText.substring(getText.indexOf(symbol) + 1, len);
        Log.e("logTextReplace", text);
        text = getText.replace(text, ("(-").concat(text).concat(")"));
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
        String getText = edtResult.getText().toString().trim();
        int len = getText.length();
        if (len == 0 || !getText.contains("=")) {
            edtResult.append(buttonName);
        }
    }


    public void addOperationToList(String text) {
        // texti operationlara bolur ve  liste yigir
        Log.e("calledMethod", "addOperationToList3");
        values = new ArrayList<>();
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
        Log.e("operation", String.valueOf(operation));

    }


    public void splitText(String text) {
        // texti yalniz + ve - gore split edir
        splittedText = new ArrayList<>();
        String[] arrayByPlus = text.split(Pattern.quote("+"));
        String result;
        for (int i = 0; i < arrayByPlus.length; i++) {
            if (arrayByPlus[i].contains("-")) {
                int indexMinus=arrayByPlus[i].indexOf("-");
                Log.e("in", String.valueOf(indexMinus));
               String beforeMinusSymbol= String.valueOf(arrayByPlus[i].charAt(indexMinus-1));
                Log.e("inSymbol", beforeMinusSymbol);

                if(!beforeMinusSymbol.equals("(")){
                    String[] array2 = arrayByPlus[i].split("-");

                    for (int j = 0; j < array2.length; j++) {
                        splittedText.add(String.valueOf(array2[j]));
                        Log.e("inArray", array2[j]);

                    }
                } else {
                   // moterize eded varsa

                }

            } else {
                splittedText.add(arrayByPlus[i]);
            }
            Log.e("splittedTextList", String.valueOf(splittedText));
        }
        for (int i = 0; i < splittedText.size(); i++) {
            if (splittedText.get(i).contains("*") || splittedText.get(i).contains(":")) {
                addValueToList(splittedText.get(i));
                result = calculateOnlyMultipyAndDivide();
                splittedText.set(i, result);
                Log.e("splittedList_list", String.valueOf(splittedText));


            }
        }
        if (text.contains(":0")) {
            edtResult.append("invalid operation");
        } else {
            addOperationToList(text);
            calculateOnlySumAndSubtract();
        }


    }

    public void addValueToList(String text) {
        // texti ededlere  bolur ve  liste yigir
        Log.e("calledMethod", "addValueToList");
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
                    Log.e("valueAdd", "valueAdded");
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

    public String calculateOnlyMultipyAndDivide() {
        String resultCheck = "";
        Log.e("calledMethod", "check");
        String op;
        double res = 0;
        Iterator<String> iterator = operation.iterator();
        while (iterator.hasNext()) {
            op = String.valueOf(iterator.next());
            if (op.equals("*")) {
                res = Double.parseDouble(values.get(0)) * Double.parseDouble(values.get(1));
             //   setValueToList(res);
                Log.e("res+", String.valueOf(res));
                values.remove(0);
                values.remove(0);
                values.add(0, String.valueOf(res));

            }
            if (op.equals(":")) {
                res = Double.parseDouble(values.get(0)) / Double.parseDouble(values.get(1));
              //  setValueToList(res);

                Log.e("res/", String.valueOf(res));
                values.remove(0);
                values.remove(0);
                values.add(0, String.valueOf(res));
            }


        }
        resultCheck = String.valueOf(res);
        Log.e("checkResult-", String.valueOf(res));
        return resultCheck;

    }


    public void calculateOnlySumAndSubtract() {
        Log.e("calledMethod", "check");
        Log.e("valueListCheck", String.valueOf(splittedText));
        String op;
        double res = 0;
        Iterator<String> iterator = operation.iterator();
        while (iterator.hasNext()) {
            op = String.valueOf(iterator.next());
            if (!operation.equals("*") && !operation.equals(":")) {
                Log.e("op", String.valueOf(op));
                if (op.equals("+")) {
                    res = Double.parseDouble(splittedText.get(0)) + Double.parseDouble(splittedText.get(1));
                    Log.e("res+", String.valueOf(res));
                    splittedText.remove(0);
                    splittedText.remove(0);
                    splittedText.add(0, String.valueOf(res));
                    Log.e("valuesAfterRemove", String.valueOf(splittedText));

                }
                if (op.equals("-")) {
                    res = Double.parseDouble(splittedText.get(0)) - Double.parseDouble(splittedText.get(1));
                    Log.e("res-", String.valueOf(res));
                    splittedText.remove(0);
                    splittedText.remove(0);
                    splittedText.add(0, String.valueOf(res));
                    Log.e("valuesAfterRemove", String.valueOf(splittedText));
                }
            }
        }
        Log.e("checkResult-", String.valueOf(res));

      //  edtResult.append(String.valueOf(res));
        edtResult.append(String.format("%.3f",res));

    }


    public void setValueToList(Double res) {
        Log.e("res+", String.valueOf(res));
        values.remove(0);
        values.remove(0);
        values.add(0, String.valueOf(res));
    }

    public String getLastNumberFromText(String inputText) {
        int i = 1;
        String result = "";
        Log.e("inputTextinMethod",inputText);
        Log.e("inputcalled","calledGetLastNumberFromText");
        String lastSymbol = String.valueOf(inputText.charAt(inputText.length() - 1));
        Log.e("logLastSymbolBefore", lastSymbol);

        while (inputText.length()>0  && !lastSymbol.equals("+") && !lastSymbol.equals("-") && !lastSymbol.equals("*") && !lastSymbol.equals(":")
                    && !inputText.endsWith(".") && !lastSymbol.equals("=")) {
                result = result.concat(String.valueOf(inputText.charAt(inputText.length() - i)));
                Log.e("logResult", result);
                i++;
                lastSymbol = String.valueOf(inputText.charAt(inputText.length() - i));
                Log.e("logLastSymbol", lastSymbol);


        }



        return result;

    }

    public String inverseText(String lastSymbol) {
        String textInverse = "";

        for (int j = 1; j < lastSymbol.length()+1; j++) {
            textInverse = textInverse.concat(String.valueOf(lastSymbol.charAt(lastSymbol.length() - j)));
            Log.e("logtextInverse", textInverse );

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
                System.out.println("splitlist =" + text);

            }
        }

    }


}

