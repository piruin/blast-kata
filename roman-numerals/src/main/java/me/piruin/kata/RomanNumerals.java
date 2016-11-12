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

    static DocimalToRomanConverter firstDigit = new DocimalToRomanConverter("I", "V", "X");
    static DocimalToRomanConverter secondDigit = new DocimalToRomanConverter("X", "L", "C");
    static DocimalToRomanConverter thirdDigit = new DocimalToRomanConverter("C", "D", "M");


    public static String from(int decimal) {
        StringBuilder roman = new StringBuilder();

        roman.append(thirdDigit.from(decimal / 100 % 10));
        roman.append(secondDigit.from(decimal / 10 % 10));
        roman.append(firstDigit.from(decimal % 10));

        return roman.toString();
    }

    private static class DocimalToRomanConverter {
        String base;
        String mid;
        String next;

        public DocimalToRomanConverter(String base, String mid, String next) {
            this.base = base;
            this.mid = mid;
            this.next = next;
        }

        public String from(int decimal) {
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
