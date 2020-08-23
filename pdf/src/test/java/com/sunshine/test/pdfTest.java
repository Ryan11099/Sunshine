package com.sunshine.test;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author yanjh
 * @date 2020/8/23 17:36
 */
public class pdfTest {
    @Test
    public void pdfTest() throws IOException, DocumentException, NoSuchFieldException, IllegalAccessException {
        // 要输出的pdf文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("C:/Users/ASUS/Desktop/开发常用/temp/123abc.pdf")));
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 将pdf文件先加水印然后输出
        setWatermark(bos, "C:/Users/ASUS/Desktop/开发常用/temp/ZHZF-0101-20200813-008.pdf", format.format(cal.getTime()) + "  下载使用人：" + "测试user", 16);
    }

    /**
     *
     * @param bos
     *          输出文件的位置
     * @param input
     *            原PDF位置
     * @param waterMarkName
     *            页脚添加水印
     * @param permission
     *            权限码
     * @throws DocumentException
     * @throws IOException
     */
    public static void setWatermark(BufferedOutputStream bos, String input, String waterMarkName, int permission)
            throws DocumentException, IOException, IllegalAccessException, NoSuchFieldException {
        PdfReader reader = new PdfReader(input);

        Field f = PdfReader.class.getDeclaredField("ownerPasswordUsed");
        f.setAccessible(true);
        f.set(reader, Boolean.TRUE);

        PdfStamper stamper = new PdfStamper(reader, bos);
        int total = reader.getNumberOfPages() + 1;
        PdfContentByte content;
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        PdfGState gs = new PdfGState();
        for (int i = 1; i < total; i++) {
//            content = stamper.getOverContent(i);// 在内容上方加水印
             content = stamper.getUnderContent(i);//在内容下方加水印
            gs.setFillOpacity(0.2f);
            // content.setGState(gs);
            content.beginText();
            content.setColorFill(BaseColor.LIGHT_GRAY);
            content.setFontAndSize(base, 50);
            content.setTextMatrix(70, 200);
            content.showTextAligned(Element.ALIGN_CENTER, "公司内部文件，请注意保密！", 300, 350, 55);
          //  Image image = Image.getInstance("C:/Users/ASUS/Desktop/开发常用/temp/demo.png");
            /*
              img.setAlignment(Image.LEFT | Image.TEXTWRAP);
              img.setBorder(Image.BOX); img.setBorderWidth(10);
              img.setBorderColor(BaseColor.WHITE); img.scaleToFit(100072);//大小
              img.setRotationDegrees(-30);//旋转
             */
          // image.setAbsolutePosition(200, 206); // set the first background
//             image of the absolute
           // image.scaleToFit(200, 200);
          //  content.addImage(image);
            content.setColorFill(BaseColor.BLACK);
            content.setFontAndSize(base, 8);
            content.showTextAligned(Element.ALIGN_CENTER, "下载时间：" + waterMarkName + "", 300, 10, 0);
            content.endText();

        }
        stamper.close();
    }

}
