import kdtree

""" Cordless Phones
    Etude 8 COSC326 2018
    @author Nikolah, Kiri, Megan and Meg.
"""

def main():

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
            points2D.append(points)

    #Print out all the points in the 2D list
    for p in points2D:
        x = p[0]
        y = p[1]
        print("East:", y, "and North:", x)

    #tree = kdtree.create(points2D)
    tree = kdtree.create(dimensions=2)

    points_length = len(points2D)
    i = 0
    while i < points_length:
        tree.add(points2D[i])
        i+=1
   
    kdtree.visualize(tree)
    print(list(tree.inorder()))
    #tree.search_knn([50, 25], 4)
    pt = [125.13,122.56]
    result = tree.search_knn(pt, 3)
    print("Nearest Neighbours are:\n", result, sep="")
        
    b = tree.is_balanced
    if b:
        print("Balanced! :)")
    else:
        print("Not balanced :(")

if __name__ == '__main__':
    main()
