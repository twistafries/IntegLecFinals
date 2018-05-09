>>> import CORBA, Hangman_Game
>>> orb = CORBA.ORB_init()
>>> o = orb.string_to_object("http://localhost:9001")
>>> o = o._narrow(Hangman_Game.(*Insert the CookieServer))
>>> print o.get_cookie()