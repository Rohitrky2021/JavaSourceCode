from collections import defaultdict
from typing import List, Dict

class U:
    def __init__(self, i: int, a: bool):
        self.i = i
        self.a = a

class C:
    def __init__(self):
        self.u: Dict[int, U] = {}
        self.m: Dict[int, int] = defaultdict(int)

    def p(self, e: List[List[str]]):
        for ev in e:
            a = ev[0]
            t = 0
            try:
                t = int(ev[1])
            except ValueError:
                print(f"Invalid timestamp: {ev[1]}")
                continue

            if a == "MESSAGE":
                ml = ev[2]
                for tk in ml.split():
                    if tk == "ALL":
                        for us in self.u.values():
                            self.m[us.i] += 1
                    elif tk == "HERE":
                        for us in self.u.values():
                            if us.a:
                                self.m[us.i] += 1
                    elif len(tk) >= 3:
                        try:
                            id_num = int(tk[2:])
                            self.m[id_num] += 1
                        except ValueError:
                            print(f"Invalid user ID: {tk[2:]}")
            elif a == "OFFLINE" and len(ev) >= 3:
                id_str = ev[2][2:]
                if id_str:
                    try:
                        id_num = int(id_str)
                        if id_num in self.u:
                            self.u[id_num].a = False
                            self.m[id_num] -= 1
                            self.m[-1] -= 1
                            if self.u[id_num].a:
                                self.m[-2] -= 1
                    except ValueError:
                        print(f"Invalid user ID: {id_str}")

    def g(self) -> List[str]:
        r = []
        for key, value in sorted(self.m.items()):
            if key >= 0:
                r.append(f"id{key} - {value}")
        return r

if __name__ == "__main__":
    e = [
        ["MESSAGE", "0", "ALL id158 id42"],
        ["OFFLINE", "1", "id158"],
        ["MESSAGE", "2", "id158 id158"],
        ["OFFLINE", "3", "id23"],
        ["MESSAGE", "60", "HERE id158 id42 id23"],
        ["MESSAGE", "61", "HERE"]
    ]

    c = C()
    c.p(e)
    r = c.g()
    for s in r:
        print(s)
