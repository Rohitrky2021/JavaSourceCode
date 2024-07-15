#include <iostream>
#include <vector>
#include <string>

std::vector<int> getSetBitIndices(int num) {
    std::string binaryString = std::bitset<32>(num).to_string();
    std::vector<int> setBitIndices;

    for (int i = 0; i < binaryString.length(); i++) {
        if (binaryString[i] == '1') {
            setBitIndices.push_back(i + 1);
        }
    }

    setBitIndices.insert(setBitIndices.begin(), setBitIndices.size());
    return setBitIndices;
}

int main() {
    int num = 161;
    std::vector<int> result = getSetBitIndices(num);

    for (int i : result) {
        std::cout << i << " ";
    }

    return 0;
}