import kdtree

""" Cordless Phones
    Etude 8 COSC326 2018
    @author Nikolah, Kiri, Megan and Meg.
"""

#
# Print out the test if the tree is balanced or not
#
def print_if_balanced(tree):
    b = tree.is_balanced
    if b:
        print("Tree is balanced! :)")
    else:
        print("Tree is not balanced :(")


#
# Take in a KDNode and return its coordinates
# Coordinates returns as list of [x, y]
#
def pull_coordinate(node):
    pstr =  str(node[0])
     
    string_cords = pstr[12:(len(pstr)-3)]
    first_q = string_cords.find(',') - 1
    second_q = first_q + 4

    xstr = string_cords[:first_q-1]
    ystr = string_cords[second_q:]
    
    pts = []
    pts.append(float(xstr))
    pts.append(float(ystr))

    return pts

def pull_all_coordinates(all_nodes):
    i = 0
    nn_points = []
    while i < len(all_nodes):
        nn_p = pull_coordinate(all_nodes[i])
        nn_points.append(nn_p)
        i+=1
    return nn_points


def main():
    #Make a list of point lists
    points = []

    #Loop until no further input, adding in each point
    while (True):
        try:
            inp = input()
        except EOFError:
            break
        if inp == "Telephone sites":
            continue
        else:
            ps = inp.split(" ")
            points.append(ps)

    #Print out all the points in the 2D list
    for p in points:
        x = p[0]
        y = p[1]
        #print("East:", y, "and North:", x)

    #print(points)
    tree = kdtree.create(points)

    '''
    #Alternately make a blank tree and then add points.
    tree = kdtree.create(dimensions=2)

    points_length = len(points)
    i = 0
    while i < points_length:
        tree.add(points[i])
        i+=1
    '''
    #kdtree.visualize(tree)
    #inord_tree = list(tree.inorder())
    #print(inord_tree)

    pt = [125.13,122.56]
    #nn_node = tree.search_nn(pt)
    #print("Nearest Neighbour is:\n", nn_node, sep="")
    
    all_nn_nodes = tree.search_knn(pt, 3)
    print("Nearest Neighbours are:\n", all_nn_nodes, sep="")
        
    #print_if_balanced(tree)

 
    nn_points = pull_all_coordinates(all_nn_nodes)
    print("The nearest neighbour points are:\n", nn_points, sep="")


if __name__ == '__main__':
    main()

