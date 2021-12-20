package RankTeamByVotes;

import java.util.*;

class Team {
	Character name;
	int[] votes;

	Team(Character name) {
		this.name = name;
	}
}

class TeamComparator implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {
		int[] o1Votes = o1.votes;
		int[] o2Votes = o2.votes;

		for (int i = 0; i < o1Votes.length; i++) {
			if (o1Votes[i] > o2Votes[i]) {
				return -1;
			} else if (o1Votes[i] < o2Votes[i]) {
				return 1;
			}
		}

		return Character.compare(o1.name, o2.name);
	}
}

class Solution {
	public String rankTeams(String[] votes) {
		Map<Character, Team> teams = new HashMap();

		String firstVote = votes[0];

		for (int i = 0; i < firstVote.length(); i++) {
			Team team = new Team(firstVote.charAt(i));
			team.votes = new int[firstVote.length()];
			team.votes[i] += 1;
			teams.put(firstVote.charAt(i), team);
		}
		for (int i = 1; i < votes.length; i++) {
			String vote = votes[i];
			for (int j = 0; j < vote.length(); j++) {
				Team team = teams.get(vote.charAt(j));

				team.votes[j] += 1;
			}
		}
		ArrayList<Team> teamss = new ArrayList<>(teams.values());

		Collections.sort(teamss, new TeamComparator());
		StringBuilder res = new StringBuilder();
		for (Team team : teamss) {
			res.append(team.name);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		test.rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"});
	}
}