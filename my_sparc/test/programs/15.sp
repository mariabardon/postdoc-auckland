sorts
#s1={a}.
#s2={b}.
#s3={c}.
#s4={d}.
#f_1=f(#s1,#s2).
#f_2=f(#s3,#s4).
#s=#f_1+#f_2.
predicates
p(#s).
rules
p(f(X,Y)).
