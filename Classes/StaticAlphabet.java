package Classes;

public class StaticAlphabet {

    public static int getLetterIndex(String letter) {

        switch(letter.toUpperCase()) {

            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            case "E": return 4;
            case "F": return 5;
            case "G": return 6;
            case "H": return 7;
            case "I": return 8;
            case "J": return 9;
            case "K": return 10;
            case "L": return 11;
            case "M": return 12;
            case "N": return 13;
            case "O": return 14;
            case "P": return 15;
            case "Q": return 16;
            case "R": return 17;
            case "S": return 18;
            case "T": return 19;
            case "U": return 20;
            case "V": return 21;
            case "W": return 22;
            case "X": return 23;
            case "Y": return 24;
            case "Z": return 25;

            default: return -1;
        }
    }

    public static String getLetter(int letterIndex) {

        switch(letterIndex) {
            
            case MyLetters.A: return "A";
            case MyLetters.B: return "B";
            case MyLetters.C: return "C";
            case MyLetters.D: return "D";
            case MyLetters.E: return "E";
            case MyLetters.F: return "F";
            case MyLetters.G: return "G";
            case MyLetters.H: return "H";
            case MyLetters.I: return "I";
            case MyLetters.J: return "J";
            case MyLetters.K: return "K";
            case MyLetters.L: return "L";
            case MyLetters.M: return "M";
            case MyLetters.N: return "N";
            case MyLetters.O: return "O";
            case MyLetters.P: return "P";
            case MyLetters.Q: return "Q";
            case MyLetters.R: return "R";
            case MyLetters.S: return "S";
            case MyLetters.T: return "T";
            case MyLetters.U: return "U";
            case MyLetters.V: return "V";
            case MyLetters.W: return "W";
            case MyLetters.X: return "X";
            case MyLetters.Y: return "Y";
            case MyLetters.Z: return "Z";

            default: return "";
        }        
    }
    
    public static class MyLetters {

        public static final int A = 0;
        public static final int B = 1;
        public static final int C = 2;
        public static final int D = 3;
        public static final int E = 4;
        public static final int F = 5;
        public static final int G = 6;
        public static final int H = 7;
        public static final int I = 8;
        public static final int J = 9;
        public static final int K = 10;
        public static final int L = 11;
        public static final int M = 12;
        public static final int N = 13;
        public static final int O = 14;
        public static final int P = 15;
        public static final int Q = 16;
        public static final int R = 17;
        public static final int S = 18;
        public static final int T = 19;
        public static final int U = 20;
        public static final int V = 21;
        public static final int W = 22;
        public static final int X = 23;
        public static final int Y = 24;
        public static final int Z = 25;
    }
}
