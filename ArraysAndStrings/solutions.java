boolean allUnique(String s) {
	Set<Character> set = new HashSet<Character>();
	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (!set.add(c))
			return false;
	}
	return true;
}

boolean allUniqueConstantSpace(String s) {
	// Assume s is all ASCII lowercase
	int bitVector = 0;
	for (int i = 0; i < s.length(); i++) {
		int val = s.charAt(i) - 'a'; // 'a' = 0, 'b' = 1, etc.
		if ((bitVector & 1 << val) > 0) {
			return false;
		} else {
			bitVector = bitVector | 1 << val;
		}
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
		// count number of each char in s
		if (flag[c] > 0) {
			flag[c] = flag[c]++;
		} else {
			flag[c] = 1;
		}
	}
	for (int i = 0; i < b.length(); i++) {
		int c = b.charAt(i) - '\0';
		flag[c]--;
		if (flag[c] < 0
	)		return false;
	}
	return true;
}

void replaceSpaces(String s) {
	StringBuilder sb = new StringBuilder();
	int[] str = s.toCharArray();
	for (int i = 0; i < str.length; i++) {
		if (s[i] == ' ') {
			sb.append("%20");
		} else {
			sb.append(s[i]);
		}
	}
	s = sb.toString();
}

String compress(String s) {
	Map<Character,Integer> map = new LinkedHashMap<>();
	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (map.containsKey(c)) {
			map.put(c, map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
	}
	StringBuilder res = new StringBuilder();
	for (Map.Entry<Character, Integer> entry: map.entrySet()) {
		res.append(entry.getKey());
		res.append(entry.getValue());
	}
	if (res.length() >= s.length()) {
		return s;
	} else {
		return res.toString();
	}
}