class A {
    public int maxHeightOfTriangle(int red, int blue) {
        int height = 0;
        while (true) {
            height++;
            if (height % 2 != 1) { // odd rows
                if (red >= height) {
                    red -= height;
                } else {
                    break;
                }
            } else { // even rows
                if (blue >= height) {
                    blue -= height;
                } else {
                    break;
                }
            }
        }
        return height - 1;
    }

    public static void main(String[] args) {
        A solution = new A();
        System.out.println(solution.maxHeightOfTriangle(2, 4)); // Output: 3
        System.out.println(solution.maxHeightOfTriangle(2, 1)); // Output: 2
        System.out.println(solution.maxHeightOfTriangle(1, 1)); // Output: 1
        System.out.println(solution.maxHeightOfTriangle(10, 1)); // Output: 2
    }
}
