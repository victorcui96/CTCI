boolean allUnique(String s) {
	Set<Character> set = new HashSet<Character>();
	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (!set.add(c))
			return false;
	}
	return true;
}

boolean permutation(String a, String b) {
	// 1 Option is to sort both strings then iterate through character by character
	if (a.length() != b.length()) {
		return false;
	}
	// Assume ASCII Characters
	boolean[] flags = new boolean[128];
	for (int i = 0; i < a.length(); i++) {
		int c = a.charAt(i) - '\0';
		if (flag[c] > 0) {
			flag[c] = flag[c]++;
		} else {
			flag[c] = 1;
		}
	}
	for (int i = 0; i < b.length(); i++) {
		int c = b.charAt(i) - '\0';
		flag[c]--;
		if (flag[c] < 0)
			return false;
	}
	return true;
}