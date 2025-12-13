class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        List<Coupon> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]
                    && code[i] != null
                    && !code[i].isEmpty()
                    && code[i].matches("[a-zA-Z0-9_]+")
                    && order.containsKey(businessLine[i])) {

                valid.add(new Coupon(code[i], businessLine[i]));
            }
        }

        valid.sort((a, b) -> {
            int cmp = order.get(a.businessLine) - order.get(b.businessLine);
            if (cmp != 0) return cmp;
            return a.code.compareTo(b.code);
        });

        List<String> result = new ArrayList<>();
        for (Coupon c : valid) {
            result.add(c.code);
        }

        return result;
    }

    static class Coupon {
        String code;
        String businessLine;

        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}
