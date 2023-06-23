package com.example.utils;

import com.ibm.icu.text.DecimalFormat;
import com.ibm.icu.text.Transliterator;
public class StringUtils {
    public static String removeVietnameseDiacritics(String input) {
        Transliterator transliterator = Transliterator.getInstance("NFD; [:Nonspacing Mark:] Remove; NFC");
        String replacedString = transliterator.transliterate(input);
        return replacedString.replace("đ", "d")
                .replaceAll("[áàảãạâấầẩẫậăắằẳẵặ]", "a")
                .replaceAll("[éèẻẽẹêếềểễệ]", "e")
                .replaceAll("[íìỉĩị]", "i")
                .replaceAll("[óòỏõọôốồổỗộơớờởỡợ]", "o")
                .replaceAll("[úùủũụưứừửữự]", "u")
                .replaceAll("[ýỳỷỹỵ]", "y");
    }
    public static String formatVietnameseCurrency(int number){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(number);
        return formattedNumber;
    }

}
