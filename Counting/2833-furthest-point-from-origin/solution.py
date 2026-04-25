class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        right = 0
        left = 0
        blank = 0
        for move in moves:
            if move == 'R':
                right += 1
            elif move == 'L':
                left += 1
            else:
                blank += 1
        return abs(right - left) + blank