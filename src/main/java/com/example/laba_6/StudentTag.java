package com.example.laba_6;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class StudentTag  extends TagSupport {
//    private int collectionSize;
//    public void setCollectionSize(int collectionSize) {
//        this.collectionSize = collectionSize;
//    }




@Override
    public int doStartTag()
{
    JspWriter out= pageContext.getOut();
    try
    {
        out.print("Hello");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return SKIP_BODY;
}
}
