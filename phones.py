import kdtree

""" Cordless Phones
    Etude 8 COSC326 2018
    @author Nikolah, Kiri, Megan and Meg.
"""

#Class Phone to store the x and y values 
class Phone:
    
    def __init__(self, east_in, north_in):
        self._east = east_in
        self._north = north_in

    def get_east(self):
        return self._east
    
    def get_north(self):
        return self._north
    
def main():

    #Make a list of phones to store each point
    phones = []
    #Make a list of point lists
    points2D = []

    #Loop until no further input, adding in each point
    while (True):
        try:
            inp = input()
        except EOFError:
            break
        if inp == "Telephone sites":
            continue
        else:
            points = inp.split(" ")
            p = Phone(points[0], points[1])
            points2D.append(points)
            phones.append(p)

    #Print out all the points
    """ for p in phones:
    e = p.get_east()
    n = p.get_north()
    print("Phone set up. East:", e, "and North:", n)
    """

    #Print out all the points in the 2D list
    for p in points2D:
        x = p[0]
        y = p[1]
        print("East:", y, "and North:", x)

    tree = kdtree.create(points2D)
    kdtree.visualize(tree)
    b = tree.is_balanced

    if b:
        print("Balanced! :)")
    else:
        print("Not balanced :(")

    print(list(tree.inorder()))
    #tree.search_nn( (1, 2, 0) )

"""
 It can provide the k nearest neighbours to a point by maintaining k current bests 
 instead of just one. A branch is only eliminated when k points have been found
 and the branch cannot have points closer than any of the k current bests.
 """
 
if __name__ == '__main__':
    main()
