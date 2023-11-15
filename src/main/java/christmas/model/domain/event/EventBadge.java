package christmas.model.domain.event;

public enum EventBadge {

    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String category;
    private final int minAmount;

    EventBadge(String category, int minAmount) {
        this.category = category;
        this.minAmount = minAmount;
    }

    public static EventBadge grantEventBadge(int minAmount) {
        if (minAmount >= SANTA.minAmount) {
            return SANTA;
        } else if (minAmount >= TREE.minAmount) {
            return TREE;
        } else if (minAmount >= STAR.minAmount) {
            return STAR;
        }
        return NONE;
    }

    public String getCategory() {
        return category;
    }

    public int getMinAmount() {
        return minAmount;
    }
}
