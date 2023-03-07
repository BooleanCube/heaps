package testing;

/**
TEST CASE GENERATOR CODE:

import random as r

n = 50
ops = ["INSERT [num]", "POP", "PEEK"]

inp = "INSERT 34"
for i in range(n):
    num = r.randint(-10e6, 10e6)
    idx = r.randrange(3)
    inp += " | " + ops[idx].replace("[num]", str(num))

out = ""
l = []
for op in inp.split(" | "):
    if op[:6] == "INSERT":
        l.append(int(op.split()[1]))
        l.sort()
    elif op=="POP":
        out += str(l.pop(0)) + " | "
    else:
        out += str(l[0]) + " | "

print(inp)
print(out[:-3])
**/
public class TestCase {
    
    // first test case (~10 operations)
    public static final String INPUT1 = "INSERT 4 | INSERT 6 | INSERT 2 | INSERT 5 | PEEK | POP | INSERT -5 | POP | PEEK";
    public static final String OUTPUT1 = "2 | 2 | -5 | 4";
    
    // second test case (~20 operations)
    public static final String INPUT2 = "INSERT 6 | INSERT 5 | INSERT 4 | INSERT 3 | INSERT 2 | INSERT 1 | INSERT 7 | POP | PEEK | INSERT 8 | INSERT 9 | POP | POP | POP | INSERT 0 | PEEK | POP | PEEK";
    public static final String OUTPUT2 = "1 | 2 | 3 | 4 | 5 | 0 | 0 | 6";
    
    // third test case (~50 operations)
    public static final String INPUT3 = "INSERT 34 | INSERT 6870858 | PEEK | INSERT 4621435 | PEEK | INSERT 8596530 | INSERT 6442974 | PEEK | POP | PEEK | INSERT -6874564 | PEEK | POP | POP | INSERT -5942988 | INSERT 1896181 | INSERT -6597926 | INSERT 9982964 | INSERT -5685353 | PEEK | PEEK | INSERT 2748597 | POP | POP | INSERT 5133834 | INSERT 4603247 | POP | PEEK | POP | PEEK | PEEK | POP | POP | POP | PEEK | POP | POP | INSERT -8204246 | PEEK | PEEK | PEEK | PEEK | INSERT 1214153 | POP | INSERT 5413420 | INSERT 1018366 | PEEK | PEEK | INSERT 5680120 | INSERT 7854433 | POP";
    public static final String OUTPUT3 = "34 | 34 | 34 | 34 | 4621435 | -6874564 | -6874564 | 4621435 | -6597926 | -6597926 | -6597926 | -5942988 | -5685353 | 1896181 | 1896181 | 2748597 | 2748597 | 2748597 | 4603247 | 5133834 | 6442974 | 6442974 | 6870858 | -8204246 | -8204246 | -8204246 | -8204246 | -8204246 | 1018366 | 1018366 | 1018366";
    
}
