import java.util.List;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            if (solve(skill, skill_trees[i])) answer++;
        }

        return answer;
    }

    public boolean solve(String skill, String skillTree) {
        boolean[] learned = new boolean[skill.length()];
        int preIndex = -1;

        for (int i = 0; i < skill.length(); i++) {
            char c = skill.charAt(i);
            for (int j = 0; j < skillTree.length(); j++) {
                if (skillTree.charAt(j) == c) {
                    if (!isPossible(j, preIndex, i, learned)) return false;
                    learned[i] = true;
                    preIndex = j;
                    break;
                }
            }
        }

        return true;
    }

    public boolean isPossible(int curIndex, int preIndex, int skillIndex, boolean[] learned) {
        if (curIndex < preIndex) return false;
        if (skillIndex > 0 && !learned[skillIndex - 1]) return false;
        return true;
    }
}
