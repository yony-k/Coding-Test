import java.util.*;

class Solution {
  public String solution(int[] numbers, String hand) {
    StringBuilder sb = new StringBuilder();

    String leftHand = "*";
    String rightHand = "#";

    for(int n : numbers) {

      if(n == 1 || n == 4 || n == 7) {
        sb.append("L");
        leftHand = String.valueOf(n);
      } else if(n == 3 || n == 6 || n == 9) {
        sb.append("R");
        rightHand = String.valueOf(n);
      } else {
        // 거리판단
        int disL = distance(n, leftHand);
        int disR = distance(n, rightHand);

        if(disL > disR) {
          sb.append("R");
          rightHand = String.valueOf(n);
        } else if(disL < disR) {
          sb.append("L");
          leftHand = String.valueOf(n);
        } else {
          if(hand.equals("left")) {
            sb.append("L");
            leftHand = String.valueOf(n);
          } else {
            sb.append("R");
            rightHand = String.valueOf(n);
          }
        }
      }
    }
    return sb.toString();
  }

  public int distance(int n, String nowString) {
    int now = 0;
      
    if(n == 0) n = 11;

    if(nowString.equals("*")) now = 10;
    else if(nowString.equals("#")) now = 12;
    else if(nowString.equals("0")) now = 11;
    else now = Integer.parseInt(nowString);

    int nLoc = 0;
    int nowLoc = 0;

    if(n == 1 || n == 2 || n == 3) nLoc = 1;
    else if(n == 4 || n == 5 || n == 6) nLoc = 2;
    else if(n == 7 || n == 8 || n == 9) nLoc = 3;
    else nLoc = 4;

    if(now == 1 || now == 2 || now == 3) nowLoc = 1;
    else if(now == 4 || now == 5 || now == 6) nowLoc = 2;
    else if(now == 7 || now == 8 || now == 9) nowLoc = 3;
    else nowLoc = 4;

    int dis = Math.abs(nowLoc - nLoc);

    if(dis != 0) {
      if(n > now) {
        now += 3*dis;
      } else {
        now -= 3*dis;
      }
    }

    while(n != now) {
      if(n > now) {
        now++;
      } else {
        now--;
      }
      dis++;
    }

    return dis;
  }
}