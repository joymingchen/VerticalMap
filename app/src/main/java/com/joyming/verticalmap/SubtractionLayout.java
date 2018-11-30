package com.joyming.verticalmap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoymingChen on 2018/11/29.
 * Email：joymingchen@foxmail.com
 * If you have any question , you can send email to me .Thanks!
 */

public class SubtractionLayout extends FrameLayout {


    //第一个数的千位
    private TextView tvOneHundredBit;
    //第一个数的百位
    private TextView tvOneTenBit;
    //第一个数的个位
    private TextView tvOneBit;

    //第二个数的千位
    private TextView tvTwoHundredBit;
    //第二个数的百位
    private TextView tvTwoTenBit;
    //第二个数的个位
    private TextView tvTwoBit;

    //个位的进位
    private EditText etBitToTen;
    //百位的进位
    private EditText etTenToHundred;

    //结果数的十万位
    private EditText etThreeTenWanBit;
    //结果数的万位
    private EditText etThreeWanBit;
    //结果数的千位
    private EditText etThreeThousandBit;
    //结果的百位
    private EditText etThreeHundredBit;
    //结果数的十位
    private EditText etThreeTenBit;
    //结果的个位
    private EditText etThreeBit;

    //是加法还是减法
    private TextView tvMethod;

    //乘法过程
    private LinearLayout linProcess;
    private LinearLayout linLineOne;
    private LinearLayout linLineTwo;
    private LinearLayout linLineThree;

    private EditText etLineOneThousandBit;
    private EditText etLineOneHundredBit;
    private EditText etLineOneTenBit;
    private EditText etLineOneBit;

    private EditText etLineTwoThousandBit;
    private EditText etLineTwoHundredBit;
    private EditText etLineTwoTenBit;
    private EditText etLineTwoBit;

    private EditText etLineThreeThousandBit;
    private EditText etLineThreeHundredBit;
    private EditText etLineThreeTenBit;
    private EditText etLineThreeBit;

    //各种状态信息
    //加法
    public final int CODE_ADDITION = 0;
    //减法
    public final int CODE_SUBTRACTION = 1;
    //乘法
    public final int CODE_MULTIPLICATION = 2;

    //第一个数
    private int firstNumber = 0;
    //第二个数
    private int secondNumber = 0;
    //结果
    private int resultNumber = 0;

    //方法类型
    private int methodType = 0;

    //第一个数的百位
    private int numberOneHundredBit = 0;
    //第一个数的十位
    private int numberOneTenBit = 0;
    //第一个数的个位
    private int numberOneBit = 0;

    //第二个数的百位
    private int numberTwoHundredBit = 0;
    //第二个数的十位
    private int numberTwoTenBit = 0;
    //第二个数的个位
    private int numberTwoBit = 0;

    //进位
    //十位进百位的进位数
    private int numberTenToHundred = 0;
    //个位进十位的进位数
    private int numberBitToTen = 0;

    //结果数的十万位
    private int numberResultTenWanBit = 0;
    //结果数的万位
    private int numberResultWanBit = 0;
    //结果数的千位
    private int numberResultThousandBit = 0;
    //结果数的百位
    private int numberResultHundredBit = 0;
    //结果数的十位
    private int numberResultTenBit = 0;
    //结果数的个位
    private int numberResultBit = 0;

    /**
     * 乘法过程相关
     */
    //乘法过程第一行的数
    private int numberLineOne = 0;
    //乘法过程第二行的数
    private int numberLineTwo = 0;
    //乘法过程第三行的数
    private int numberLineThree = 0;


    //乘法过程第一行的千位
    private int numberLineOneThousandBit = 0;
    //乘法过程第一行的百位
    private int numberLineOneHundredBit = 0;
    //乘法过程第一行的十位
    private int numberLineOneTenBit = 0;
    //乘法过程第一行的个位
    private int numberLineOneBit = 0;

    //乘法过程第二行的千位
    private int numberLineTwoThousandBit = 0;
    //乘法过程第二行的百位
    private int numberLineTwoHundredBit = 0;
    //乘法过程第二行的十位
    private int numberLineTwoTenBit = 0;
    //乘法过程第二行的个位
    private int numberLineTwoBit = 0;

    //乘法过程第三行的千位
    private int numberLineThreeThousandBit = 0;
    //乘法过程第三行的百位
    private int numberLineThreeHundredBit = 0;
    //乘法过程第三行的十位
    private int numberLineThreeTenBit = 0;
    //乘法过程第三行的个位
    private int numberLineThreeBit = 0;


    private List<EditText> editTextList = new ArrayList<>();

    public SubtractionLayout(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public SubtractionLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SubtractionLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public SubtractionLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }


    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_subtraction, null);
        tvMethod = view.findViewById(R.id.tv_method);

        tvOneHundredBit = view.findViewById(R.id.tv_one_hundred_bit);
        tvOneTenBit = view.findViewById(R.id.tv_one_ten_bit);
        tvOneBit = view.findViewById(R.id.tv_one_bit);

        tvTwoHundredBit = view.findViewById(R.id.tv_two_hundred_bit);
        tvTwoTenBit = view.findViewById(R.id.tv_two_ten_bit);
        tvTwoBit = view.findViewById(R.id.tv_two_bit);

        etTenToHundred = view.findViewById(R.id.et_two_ten_to_hundred);
        etBitToTen = view.findViewById(R.id.et_two_bit_to_ten);

        etThreeTenWanBit = view.findViewById(R.id.et_three_ten_wan_bit);
        etThreeWanBit = view.findViewById(R.id.et_three_wan_bit);
        etThreeThousandBit = view.findViewById(R.id.et_three_thousand_bit);
        etThreeHundredBit = view.findViewById(R.id.et_three_hundred_bit);
        etThreeTenBit = view.findViewById(R.id.et_three_ten_bit);
        etThreeBit = view.findViewById(R.id.et_three_bit);

        linProcess = view.findViewById(R.id.lin_process);
        linLineOne = view.findViewById(R.id.lin_line_one);
        linLineTwo = view.findViewById(R.id.lin_line_two);
        linLineThree = view.findViewById(R.id.lin_line_three);

        etLineOneThousandBit = view.findViewById(R.id.et_line_one_four);
        etLineOneHundredBit = view.findViewById(R.id.et_line_one_three);
        etLineOneTenBit = view.findViewById(R.id.et_line_one_two);
        etLineOneBit = view.findViewById(R.id.et_line_one_one);

        etLineTwoThousandBit = view.findViewById(R.id.et_line_two_four);
        etLineTwoHundredBit = view.findViewById(R.id.et_line_two_three);
        etLineTwoTenBit = view.findViewById(R.id.et_line_two_two);
        etLineTwoBit = view.findViewById(R.id.et_line_two_one);

        etLineThreeThousandBit = view.findViewById(R.id.et_line_three_four);
        etLineThreeHundredBit = view.findViewById(R.id.et_line_three_three);
        etLineThreeTenBit = view.findViewById(R.id.et_line_three_two);
        etLineThreeBit = view.findViewById(R.id.et_line_three_one);


        addView(view); //把自定义的这个组合控件的布局加入到当前FramLayout

        initData();


    }

    private void setListener() {
        editTextList.clear();

        if (linProcess.getVisibility() == VISIBLE) {
            if (linLineOne.getVisibility() == VISIBLE) {
                //乘法过程第一行
                if (etLineOneBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineOneBit);
                if (etLineOneTenBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineOneTenBit);
                if (etLineOneHundredBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineOneHundredBit);
                if (etLineOneThousandBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineOneThousandBit);
            }
            if (linLineTwo.getVisibility() == VISIBLE) {
                //乘法过程第二行
                if (etLineTwoBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineTwoBit);
                if (etLineTwoTenBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineTwoTenBit);
                if (etLineTwoHundredBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineTwoHundredBit);
                if (etLineTwoThousandBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineTwoThousandBit);
            }
            if (linLineThree.getVisibility() == VISIBLE) {
                //乘法过程第三行
                if (etLineThreeBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineThreeBit);
                if (etLineThreeTenBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineThreeTenBit);
                if (etLineThreeHundredBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineThreeHundredBit);
                if (etLineThreeThousandBit.getVisibility() == VISIBLE)
                    editTextList.add(etLineThreeThousandBit);
            }
        }
        //结果数
        if (etThreeBit.getVisibility() == VISIBLE)
            editTextList.add(etThreeBit);
        //进位
        if (etBitToTen.getVisibility() == VISIBLE)
            editTextList.add(etBitToTen);
        if (etThreeTenBit.getVisibility() == VISIBLE)
            editTextList.add(etThreeTenBit);
        //进位
        if (etTenToHundred.getVisibility() == VISIBLE)
            editTextList.add(etTenToHundred);
        if (etThreeHundredBit.getVisibility() == VISIBLE)
            editTextList.add(etThreeHundredBit);
        if (etThreeThousandBit.getVisibility() == VISIBLE)
            editTextList.add(etThreeThousandBit);
        if (etThreeWanBit.getVisibility() == VISIBLE)
            editTextList.add(etThreeWanBit);
        if (etThreeTenWanBit.getVisibility() == VISIBLE)
            editTextList.add(etThreeTenWanBit);


        for (int i = 0; i < editTextList.size(); i++) {
            final int finalI = i;
            editTextList.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (count >= 1) {
                        if (finalI < editTextList.size() - 1 && finalI >= 0) {
                            editTextList.get((finalI + 1)).requestFocus();
                        } else if (finalI == editTextList.size() - 1) {
                            editTextList.get(0).requestFocus();
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }

    private void initData() {
        switch (methodType) {
            case CODE_ADDITION://加法
                tvMethod.setText("+");
                linProcess.setVisibility(GONE);
                addition();
                break;
            case CODE_SUBTRACTION://减法
                tvMethod.setText("-");
                linProcess.setVisibility(GONE);
                subtraction();
                break;
            case CODE_MULTIPLICATION://乘法
                tvMethod.setText("×");
                linProcess.setVisibility(VISIBLE);
                multiplication();
                break;
        }
        //设置监听事件
        setListener();
    }

    /**
     * 乘法
     */
    private void multiplication() {
        //结果
        resultNumber = firstNumber * secondNumber;

        //进位判断，乘法没有进位，全部隐藏
        numberBitToTen = 0;
        numberTenToHundred = 0;
        etBitToTen.setVisibility(INVISIBLE);
        etTenToHundred.setVisibility(INVISIBLE);

        if (resultNumber >= 0) {
            //设置第一个数和第二个数
            setFirstAndSecondTextView();

            if (firstNumber < 10 || secondNumber < 10) {
                linProcess.setVisibility(GONE);
            } else {
                //设置过程的展示
                setProcessTextView();
            }
            //设置结果展示
            setResultTextView();
        } else {
            throw new NumberFormatException("不支持负数的运算，小学三位数以内的运算");
        }

    }

    /**
     * 减法
     */
    private void subtraction() {
        //结果
        resultNumber = firstNumber - secondNumber;

        //进位判断，减法没有进位，全部隐藏
        numberBitToTen = 0;
        numberTenToHundred = 0;
        etBitToTen.setVisibility(INVISIBLE);
        etTenToHundred.setVisibility(INVISIBLE);

        if (resultNumber >= 0) {
            //设置第一个数和第二个数
            setFirstAndSecondTextView();
            //设置结果展示
            setResultTextView();
        } else {
            throw new NumberFormatException("不支持负数的运算，小学三位数以内的运算");
        }
    }

    /**
     * 加法
     */
    private void addition() {
        //结果
        resultNumber = firstNumber + secondNumber;

        //设置第一个数和第二个数
        setFirstAndSecondTextView();

        //进位
        numberBitToTen = (numberOneBit + numberTwoBit) / 10;
        numberTenToHundred = (numberOneTenBit + numberTwoTenBit + numberBitToTen) / 10;
        etBitToTen.setVisibility(numberBitToTen == 0 ? INVISIBLE : VISIBLE);
        etTenToHundred.setVisibility(numberTenToHundred == 0 ? INVISIBLE : VISIBLE);

        //设置结果展示
        setResultTextView();
    }

    /**
     * 设置第一个数和第二个数的展示
     */
    private void setFirstAndSecondTextView() {
        //第一个数
        numberOneHundredBit = firstNumber / 100;
        numberOneTenBit = (firstNumber % 100) / 10;
        numberOneBit = (firstNumber % 100) % 10;
        tvOneHundredBit.setText(numberOneHundredBit + "");
        tvOneTenBit.setText(numberOneTenBit + "");
        tvOneBit.setText(numberOneBit + "");
        if (numberOneHundredBit == 0) {
            tvOneHundredBit.setVisibility(INVISIBLE);
            if (numberOneTenBit == 0) {
                tvOneTenBit.setVisibility(INVISIBLE);
            } else {
                tvOneTenBit.setVisibility(VISIBLE);
            }
        } else {
            tvOneHundredBit.setVisibility(VISIBLE);
            tvOneTenBit.setVisibility(VISIBLE);
        }

        //第二个数
        numberTwoHundredBit = secondNumber / 100;
        numberTwoTenBit = (secondNumber % 100) / 10;
        numberTwoBit = (secondNumber % 100) % 10;
        tvTwoHundredBit.setText(numberTwoHundredBit + "");
        tvTwoTenBit.setText(numberTwoTenBit + "");
        tvTwoBit.setText(numberTwoBit + "");
        if (numberTwoHundredBit == 0) {
            tvTwoHundredBit.setVisibility(INVISIBLE);
            if (numberTwoTenBit == 0) {
                tvTwoTenBit.setVisibility(INVISIBLE);
            } else {
                tvTwoTenBit.setVisibility(VISIBLE);
            }
        } else {
            tvTwoHundredBit.setVisibility(VISIBLE);
            tvTwoTenBit.setVisibility(VISIBLE);
        }
    }

    /**
     * 设置过程的结果展示
     */
    private void setProcessTextView() {
        numberLineOne = firstNumber * numberTwoBit;
        numberLineTwo = firstNumber * numberTwoTenBit;
        numberLineThree = firstNumber * numberTwoHundredBit;

        numberLineOneThousandBit = numberLineOne / 1000;
        numberLineOneHundredBit = (numberLineOne % 1000) / 100;
        numberLineOneTenBit = (numberLineOne % 100) / 10;
        numberLineOneBit = (numberLineOne % 100) % 10;

        numberLineTwoThousandBit = numberLineTwo / 1000;
        numberLineTwoHundredBit = (numberLineTwo % 1000) / 100;
        numberLineTwoTenBit = (numberLineTwo % 100) / 10;
        numberLineTwoBit = (numberLineTwo % 100) % 10;

        numberLineThreeThousandBit = numberLineThree / 1000;
        numberLineThreeHundredBit = (numberLineThree % 1000) / 100;
        numberLineThreeTenBit = (numberLineThree % 100) / 10;
        numberLineThreeBit = (numberLineThree % 100) % 10;

        if (numberLineOne == 0) {
            linLineOne.setVisibility(GONE);
        } else {
            linLineOne.setVisibility(VISIBLE);
            //千位
            if (numberLineOneThousandBit == 0) {
                etLineOneThousandBit.setVisibility(GONE);
                //百位
                if (numberLineOneHundredBit == 0) {
                    etLineOneHundredBit.setVisibility(GONE);
                    //十位
                    if (numberLineOneTenBit == 0) {
                        etLineOneTenBit.setVisibility(GONE);
                    } else {
                        etLineOneHundredBit.setVisibility(VISIBLE);
                        etLineOneTenBit.setVisibility(VISIBLE);
                    }
                } else {
                    etLineOneHundredBit.setVisibility(VISIBLE);
                    etLineOneTenBit.setVisibility(VISIBLE);
                    etLineOneBit.setVisibility(VISIBLE);
                }
            } else {
                etLineOneThousandBit.setVisibility(VISIBLE);
                etLineOneHundredBit.setVisibility(VISIBLE);
                etLineOneTenBit.setVisibility(VISIBLE);
                etLineOneBit.setVisibility(VISIBLE);
            }
        }

        if (numberLineTwo == 0) {
            linLineTwo.setVisibility(GONE);
        } else {
            linLineTwo.setVisibility(VISIBLE);
            //千位
            if (numberLineTwoThousandBit == 0) {
                etLineTwoThousandBit.setVisibility(GONE);
                //百位
                if (numberLineTwoHundredBit == 0) {
                    etLineTwoHundredBit.setVisibility(GONE);
                    //十位
                    if (numberLineTwoTenBit == 0) {
                        etLineTwoTenBit.setVisibility(GONE);
                    } else {
                        etLineTwoHundredBit.setVisibility(VISIBLE);
                        etLineTwoTenBit.setVisibility(VISIBLE);
                    }
                } else {
                    etLineTwoHundredBit.setVisibility(VISIBLE);
                    etLineTwoTenBit.setVisibility(VISIBLE);
                    etLineTwoBit.setVisibility(VISIBLE);
                }
            } else {
                etLineTwoThousandBit.setVisibility(VISIBLE);
                etLineTwoHundredBit.setVisibility(VISIBLE);
                etLineTwoTenBit.setVisibility(VISIBLE);
                etLineTwoBit.setVisibility(VISIBLE);
            }
        }

        if (numberLineThree == 0) {
            linLineThree.setVisibility(GONE);
        } else {
            linLineThree.setVisibility(VISIBLE);
            //千位
            if (numberLineThreeThousandBit == 0) {
                etLineThreeThousandBit.setVisibility(GONE);
                //百位
                if (numberLineThreeHundredBit == 0) {
                    etLineThreeHundredBit.setVisibility(GONE);
                    //十位
                    if (numberLineThreeTenBit == 0) {
                        etLineThreeTenBit.setVisibility(GONE);
                    } else {
                        etLineThreeHundredBit.setVisibility(VISIBLE);
                        etLineThreeTenBit.setVisibility(VISIBLE);
                    }
                } else {
                    etLineThreeHundredBit.setVisibility(VISIBLE);
                    etLineThreeTenBit.setVisibility(VISIBLE);
                    etLineThreeBit.setVisibility(VISIBLE);
                }
            } else {
                etLineThreeThousandBit.setVisibility(VISIBLE);
                etLineThreeHundredBit.setVisibility(VISIBLE);
                etLineThreeTenBit.setVisibility(VISIBLE);
                etLineThreeBit.setVisibility(VISIBLE);
            }
        }

    }

    /**
     * 设置结果的展示形式
     */
    private void setResultTextView() {
        //结果数
        numberResultTenWanBit = resultNumber / 100000;
        numberResultWanBit = (resultNumber % 100000) / 10000;
        numberResultThousandBit = (resultNumber % 10000) / 1000;
        numberResultHundredBit = (resultNumber % 1000) / 100;
        numberResultTenBit = (resultNumber % 100) / 10;
        numberResultBit = (resultNumber % 100) % 10;

        //十万位
        if (numberResultTenWanBit == 0) {
            etThreeTenWanBit.setVisibility(GONE);
            //万位
            if (numberResultWanBit == 0) {
                etThreeWanBit.setVisibility(GONE);
                //千位
                if (numberResultThousandBit == 0) {
                    etThreeThousandBit.setVisibility(GONE);
                    //百位
                    if (numberResultHundredBit == 0) {
                        etThreeHundredBit.setVisibility(GONE);
                        //十位
                        if (numberResultTenBit == 0) {
                            etThreeTenBit.setVisibility(GONE);
                        } else {
                            etThreeTenBit.setVisibility(VISIBLE);
                        }
                    } else {
                        etThreeHundredBit.setVisibility(VISIBLE);
                        etThreeTenBit.setVisibility(VISIBLE);
                    }
                } else {
                    etThreeThousandBit.setVisibility(VISIBLE);
                    etThreeHundredBit.setVisibility(VISIBLE);
                    etThreeTenBit.setVisibility(VISIBLE);
                }
            } else {
                etThreeWanBit.setVisibility(VISIBLE);
                etThreeThousandBit.setVisibility(VISIBLE);
                etThreeHundredBit.setVisibility(VISIBLE);
                etThreeTenBit.setVisibility(VISIBLE);
            }
        } else {
            etThreeTenWanBit.setVisibility(VISIBLE);
            etThreeWanBit.setVisibility(VISIBLE);
            etThreeThousandBit.setVisibility(VISIBLE);
            etThreeHundredBit.setVisibility(VISIBLE);
            etThreeTenBit.setVisibility(VISIBLE);
        }


    }

    /**
     * 设置方法和数字
     *
     * @param firstNumber
     * @param secondNumber
     * @param methodType
     */
    public void setNumber(int firstNumber, int secondNumber, int methodType) {
        this.methodType = methodType;

        if (firstNumber >= 0 && firstNumber <= 999) {
            this.firstNumber = firstNumber;
        } else {
            throw new NumberFormatException("只支持三位数");
        }
        if (secondNumber >= 0 && secondNumber <= 999) {
            this.secondNumber = secondNumber;
        } else {
            throw new NumberFormatException("只支持三位数");
        }
        //更新界面，初始化数据
        initData();
    }

    /**
     * 判断用户结果输入是否正确
     *
     * @return
     */
    public boolean isTrueAnswer() {
        int userTenWanBit = 0;
        int userWanBit = 0;
        int userThousandBit = 0;
        int userHundredBit = 0;
        int userTenBit = 0;
        int userBit = 0;
        int userTenCarry = 0;
        int userBitCarry = 0;

        if (isInteger(etThreeTenWanBit.getText().toString()) && etThreeTenWanBit.getVisibility() == VISIBLE) {
            userTenWanBit = Integer.parseInt(etThreeTenWanBit.getText().toString());
        }
        if (isInteger(etThreeWanBit.getText().toString()) && etThreeWanBit.getVisibility() == VISIBLE) {
            userWanBit = Integer.parseInt(etThreeWanBit.getText().toString());
        }
        if (isInteger(etThreeThousandBit.getText().toString()) && etThreeThousandBit.getVisibility() == VISIBLE) {
            userThousandBit = Integer.parseInt(etThreeThousandBit.getText().toString());
        }
        if (isInteger(etThreeHundredBit.getText().toString()) && etThreeHundredBit.getVisibility() == VISIBLE) {
            userHundredBit = Integer.parseInt(etThreeHundredBit.getText().toString());
        }
        if (isInteger(etThreeTenBit.getText().toString()) && etThreeTenBit.getVisibility() == VISIBLE) {
            userTenBit = Integer.parseInt(etThreeTenBit.getText().toString());
        }
        if (isInteger(etThreeBit.getText().toString()) && etThreeBit.getVisibility() == VISIBLE) {
            userBit = Integer.parseInt(etThreeBit.getText().toString());
        }
        if (isInteger(etBitToTen.getText().toString()) && etBitToTen.getVisibility() == VISIBLE) {
            userBitCarry = Integer.parseInt(etBitToTen.getText().toString());
        }
        if (isInteger(etTenToHundred.getText().toString()) && etTenToHundred.getVisibility() == VISIBLE) {
            userTenCarry = Integer.parseInt(etTenToHundred.getText().toString());
        }

        int userAnswer = userTenWanBit * 100000
                + userWanBit * 10000
                + userThousandBit * 1000
                + userHundredBit * 100
                + userTenBit * 10
                + userBit;

        /**
         * 乘法的计算过程
         */
        //第一行
        int lineOneThousandBit = 0;
        int lineOneHundredBit = 0;
        int lineOneTenBit = 0;
        int lineOneBit = 0;

        if (isInteger(etLineOneThousandBit.getText().toString()) && etLineOneThousandBit.getVisibility() == VISIBLE) {
            lineOneThousandBit = Integer.parseInt(etLineOneThousandBit.getText().toString());
        }
        if (isInteger(etLineOneHundredBit.getText().toString()) && etLineOneHundredBit.getVisibility() == VISIBLE) {
            lineOneHundredBit = Integer.parseInt(etLineOneHundredBit.getText().toString());
        }
        if (isInteger(etLineOneTenBit.getText().toString()) && etLineOneTenBit.getVisibility() == VISIBLE) {
            lineOneTenBit = Integer.parseInt(etLineOneTenBit.getText().toString());
        }
        if (isInteger(etLineOneBit.getText().toString()) && etLineOneBit.getVisibility() == VISIBLE) {
            lineOneBit = Integer.parseInt(etLineOneBit.getText().toString());
        }
        //计算过程第一行的数
        int lineOne = lineOneThousandBit * 1000
                + lineOneHundredBit * 100
                + lineOneTenBit * 10
                + lineOneBit;

        //第二行
        int lineTwoThousandBit = 0;
        int lineTwoHundredBit = 0;
        int lineTwoTenBit = 0;
        int lineTwoBit = 0;

        if (isInteger(etLineTwoThousandBit.getText().toString()) && etLineTwoThousandBit.getVisibility() == VISIBLE) {
            lineTwoThousandBit = Integer.parseInt(etLineTwoThousandBit.getText().toString());
        }
        if (isInteger(etLineTwoHundredBit.getText().toString()) && etLineTwoHundredBit.getVisibility() == VISIBLE) {
            lineTwoHundredBit = Integer.parseInt(etLineTwoHundredBit.getText().toString());
        }
        if (isInteger(etLineTwoTenBit.getText().toString()) && etLineTwoTenBit.getVisibility() == VISIBLE) {
            lineTwoTenBit = Integer.parseInt(etLineTwoTenBit.getText().toString());
        }
        if (isInteger(etLineTwoBit.getText().toString()) && etLineTwoBit.getVisibility() == VISIBLE) {
            lineTwoBit = Integer.parseInt(etLineTwoBit.getText().toString());
        }
        //计算过程第二行的数
        int lineTwo = lineTwoThousandBit * 1000
                + lineTwoHundredBit * 100
                + lineTwoTenBit * 10
                + lineTwoBit;

        //第二行
        int lineThreeThousandBit = 0;
        int lineThreeHundredBit = 0;
        int lineThreeTenBit = 0;
        int lineThreeBit = 0;

        if (isInteger(etLineThreeThousandBit.getText().toString()) && etLineThreeThousandBit.getVisibility() == VISIBLE) {
            lineThreeThousandBit = Integer.parseInt(etLineThreeThousandBit.getText().toString());
        }
        if (isInteger(etLineThreeHundredBit.getText().toString()) && etLineThreeHundredBit.getVisibility() == VISIBLE) {
            lineThreeHundredBit = Integer.parseInt(etLineThreeHundredBit.getText().toString());
        }
        if (isInteger(etLineThreeTenBit.getText().toString()) && etLineThreeTenBit.getVisibility() == VISIBLE) {
            lineThreeTenBit = Integer.parseInt(etLineThreeTenBit.getText().toString());
        }
        if (isInteger(etLineThreeBit.getText().toString()) && etLineThreeBit.getVisibility() == VISIBLE) {
            lineThreeBit = Integer.parseInt(etLineThreeBit.getText().toString());
        }
        //计算过程第三行的数
        int lineThree = lineThreeThousandBit * 1000
                + lineThreeHundredBit * 100
                + lineThreeTenBit * 10
                + lineThreeBit;

        if (userAnswer == resultNumber && userBitCarry == numberBitToTen && userTenCarry == numberTenToHundred) {
            if (linProcess.getVisibility() == GONE) {
                return true;
            } else {
                if (lineOne == numberLineOne && lineTwo == numberLineTwo && lineThree == numberLineThree) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    /**
     * 判断字符串是否是整数
     */
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getNumberLineOne() {
        return numberLineOne;
    }

    public int getNumberLineTwo() {
        return numberLineTwo;
    }

    public int getNumberLineThree() {
        return numberLineThree;
    }

    public int getResultNumber() {
        return resultNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        if (firstNumber >= 0 && firstNumber <= 999) {
            this.firstNumber = firstNumber;
        } else {
            throw new NumberFormatException("只支持三位数");
        }
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        if (secondNumber >= 0 && secondNumber <= 999) {
            this.secondNumber = secondNumber;
        } else {
            throw new NumberFormatException("只支持三位数");
        }
    }
}
