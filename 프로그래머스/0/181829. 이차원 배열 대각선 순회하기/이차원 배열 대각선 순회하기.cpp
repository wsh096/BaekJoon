#include <string>
#include <vector>
#include <cmath>
using namespace std;

int solution(vector<vector<int>> board, int k) {
    int answer = 0;
    for(int i = 0; i < board.size(); i++){
        for(int j = 0; j < board[0].size(); j++){
            if(i + j <= k){
                answer += board[i][j];
            }else{
                break;
            }
        }
    }
    return answer;
}