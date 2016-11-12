/*
 * Copyright (c) 2016 Piruin Panichphol
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

package me.piruin.kata;

public class RomanNumerals {

    public static final int MAX_INPUT = 10000;

    private static DecimalToRoman FIRST = new DecimalToRoman("I", "V", "X");
    private static DecimalToRoman SECOND = new DecimalToRoman("X", "L", "C");
    private static DecimalToRoman THIRD = new DecimalToRoman("C", "D", "M");
    private static DecimalToRoman FORTH = new DecimalToRoman("M", "𐆗", "𐆖");


    public static String from(int decimal) {
        if (decimal > 10000) {
            throw new IllegalArgumentException("Input exceed limit. should in range [1-10000]");
        }
        if (decimal < 1) {
            throw new IllegalArgumentException("Input must be positive value");
        }
        if (decimal == 10000) {
            return "𐆖";
        }

        StringBuilder roman = new StringBuilder();
        roman.append(FORTH.from(decimal / 1000 % 10));
        roman.append(THIRD.from(decimal / 100 % 10));
        roman.append(SECOND.from(decimal / 10 % 10));
        roman.append(FIRST.from(decimal % 10));
        return roman.toString();
    }

    public static class DecimalToRoman {
        String base;
        String mid;
        String next;

        public DecimalToRoman(String base, String mid, String next) {
            this.base = base;
            this.mid = mid;
            this.next = next;
        }

        public String from(int decimal) {
            if (decimal >= 10) {
                throw new IllegalArgumentException("Input mist be 0-9");
            }

            StringBuilder output = new StringBuilder();
            if (decimal == 9) {
                decimal -= 9;
                output.append(base).append(next);
            }
            if (decimal >= 5) {
                decimal -= 5;
                output.append(mid);
            }
            if (decimal == 4) {
                decimal -= 4;
                output.append(base).append(mid);
            }
            while (decimal > 0) {
                decimal -= 1;
                output.append(base);
            }
            return output.toString();
        }
    }
}
