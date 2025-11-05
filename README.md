CS456-Assignment-3-Local-Search

8 Queens Puzzle problem solution code

Implemented Algorithms

    -- Hill Climbing Search Algorithm
        -- Uses random with seed for tie-breakers on possible successor states.
        -- Program stops once heuristic = 0 for the current solution state (no queens can attack each other) or once algorithm gets stuck (no equal or better neighbors).
        -- Prints step number, solution state board configuration, and heuristic value in each iteration.

    -- Simulated Annealing Search Algorithm
        -- Uses probabilistic acceptance.
        -- Randomness is controlled by seed to reproduce results.
        -- Initial temperature = 100
        -- Cooling rate = 0.95
        -- Executes for up to input chosen number of iterations (eg: 00-99), stopping early if heuristic = 0.
        -- Prints step number, solution state board configuration, and temperature in each iteration.

Core Ideas

    -- The heuristic function is calculated by counting the pairs of queens that can attack each other.
    -- The same heuristic function is used by both algorithms.
    -- Queens can only move vertically along their column when generating neighbor states.
    -- The Hill Climbing Search Algorithm moves to the neighbor state with the lowest heuristic function.
    -- The Simulated Annealing Search Algorithm allows moves to higher heuristic function neighbor states with decreasing probability as temperature cools.

Input

    -- board: Eight character string of numbers (for example: 23142631).
            - Index: column where the queen is located.
            - Value of index (0–7): queen’s position in that column.
    -- seed: Integer to allow for control of randomization for reproducing results.
    -- Max iterations (for Simulated Annealing): Maximum number of iterations allowed for the Simulated Annealing search.
