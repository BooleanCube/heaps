package testing;

/**
TEST CASE GENERATOR CODE:

import random as r

n = 20000
ops = ["INSERT [num]", "POP", "PEEK"]
inp = "INSERT 34"
val = 1
for i in range(n):
    num = r.randint(-10e6, 10e6)
    idx = r.randrange(3)
    if val > 0:
        inp += " | " + ops[idx].replace("[num]", str(num))
    else:
        inp += " | INSERT " + str(num)
    if idx==0: val += 1
    if idx==1: val -= 1
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
    public static final String INPUT3 = "INSERT 34 | POP | INSERT 223762 | INSERT -3426221 | INSERT 2167863 | INSERT 6423888 | INSERT -9494678 | INSERT -2695752 | INSERT -5427779 | PEEK | POP | INSERT -216556 | INSERT -9068885 | INSERT 2849072 | POP | INSERT 1875689 | INSERT 5422704 | PEEK | INSERT 1305244 | PEEK | INSERT -6676302 | PEEK | POP | PEEK | INSERT -9462164 | POP | INSERT 685443 | INSERT -2780902 | INSERT -1933859 | PEEK | POP | PEEK | PEEK | INSERT -7974897 | INSERT 3986630 | INSERT 8942935 | INSERT -8436429 | INSERT 770129 | POP | POP | PEEK | INSERT -5647910 | POP | PEEK | INSERT -610390 | POP | PEEK | PEEK | POP | INSERT -5875704 | PEEK";
    public static final String OUTPUT3 = "34 | -9494678 | -9494678 | -9068885 | -5427779 | -5427779 | -6676302 | -6676302 | -5427779 | -9462164 | -5427779 | -5427779 | -3426221 | -3426221 | -8436429 | -7974897 | -3426221 | -5647910 | -3426221 | -3426221 | -2780902 | -2780902 | -2780902 | -5875704";
    
}
