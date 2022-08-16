package org.example.backtracking_recursion;//package com.dsa.backtracking_recursion;
//
//public class NQueens {
//    static boolean isSafe(int[][] grid, int row, int col){
//        for(int i=row-1, j=col-1; i >=0 && j >= 0; i--, j--){
//            if(grid[i][j]==1){
//                return false;
//            }
//        }
//
//        for(int i=row-1; i>=0; i--){
//            if(grid[i][col] == 1){
//                return false;
//            }
//        }
//
//        for(int i=row-1, j=col+1; i>=0 && j < grid[0].length; i--, j++){
//            if(grid[i][j] == 1){
//                return false;
//            }
//        }
//
//        return true;
//    }
//    static void placeNqueens(int[][] grid, int row, String psf){
//        if(row == grid.length) {
//            System.out.println(psf);
//            return;
//        }
//
//        for (int col = 0; col < grid[0].length; col++) {
//            if(isSafe(grid, row, col)) {
//                grid[row][col] = 1;
//                placeNqueens(grid, row + 1, psf + row + col + "-");
//                grid[row][col] = 0;
//            }
//        }
//
//    }
//    public static void main(String[] args){
//        int[][] grid = {
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0}
//        };
//
//        StringBuilder sb  = new StringBuilder()
//
//        placeNqueens(grid, 0, "");
//
//    }
//}
