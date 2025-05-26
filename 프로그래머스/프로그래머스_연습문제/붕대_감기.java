class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int curHealth = health;
        int curTime = 0;
        int combo = 0;

        for (int i = 0; i < attacks.length; i++) {
            int nextAttackTime = attacks[i][0];
            int damage = attacks[i][1];

            int duration = nextAttackTime - curTime - 1;
            if (duration > 0) {

                curHealth += bandage[1] * duration;
                combo += duration;

                int fullComboCount = combo / bandage[0];
                curHealth += fullComboCount * bandage[2];

                if (curHealth > maxHealth) {
                    curHealth = maxHealth;
                }
            }

            curHealth -= damage;
            if (curHealth <= 0) return -1;

            combo = 0;
            curTime = nextAttackTime;
        }

        return curHealth;
    }
}
