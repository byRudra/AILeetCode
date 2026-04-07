class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        xresult = 0
        yresult = 0
        for move in moves:
            if move == 'U':
                xresult += 1
            elif move == 'D':
                xresult -= 1
            elif move == 'L':
                yresult -= 1
            elif move == 'R':
                yresult += 1
        return xresult == 0 and yresult == 0
        