import sys

def check_convex(p1, p2, p3):
    dx1 = p2.x - p1.x
    dy1 = p2.y - p1.y
    dx2 = p3.x - p2.x
    dy2 = p3.y - p2.y
    return ((dx1 * dy2) - (dy1 * dx2))


def signed_triangle_area(a, b, c):
    return (((a.x * b.y) - (a.y * b.x) + (a.y * c.x) - (a.x * c.y)
                + (b.x * c.y) - (c.x * b.y)) / 2.0);

def ccw(a, b ,c):
    area = signed_triangle_area(a, b, c)
    if area > 0:
        return True
    else:
        return False

def actullyPolygon(linelist):
    for j in range(len(linelist)):
        for i in range(j + 1, len(linelist)):
            line1 = linelist[j]
            line2 = linelist[i]
            if check_convex(line1.p1, line1.p2, line2.p1) * check_convex(line1.p1, line1.p2, line2.p2) < 0 and check_convex(line2.p1, line2.p2, line1.p1) * check_convex(line2.p1, line2.p2, line1.p2) < 0:
                return False

    return True

class Vertex:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def describe(self):
        print("X %d" % self.x, "Y %d" % self.y)

class Line:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2


lines = [line.rstrip("\n") for line in sys.stdin]


currentLine = 0

while(True):
    nodes = int(lines[currentLine])
    total_angle = (nodes - 2) * 180
    if(nodes == 0):
        break
    nodelist = list()
    linelist = list()
    currentLine += 1
    for i in range(nodes):
        data = list(map(int, lines[currentLine].split()))
        nodelist.append(Vertex(data[0], data[1]))
        currentLine += 1

    for j in range(len(nodelist)):
        point1 = nodelist[j]
        point2 = nodelist[(j + 1) % len(nodelist)]
        linelist.append(Line(point1, point2))

    not_a_polygon = actullyPolygon(linelist)

    if not not_a_polygon:
        print("No")
    else:
        critical_point = True
        left_or_right = ccw(nodelist[0], nodelist[1], nodelist[2])
        for j in range(1, len(nodelist)):
            next_turn = ccw(nodelist[j], nodelist[(j + 1) % len(nodelist)], nodelist[(j + 2) % len(nodelist)])
            if(next_turn != left_or_right):
                critical_point = False
                break

        if not critical_point:
            print("Yes")
        else:
            print("No")
