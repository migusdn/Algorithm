package SamsungDxAlgorithm.No12;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


class FileNode {
    int intDir;
    List<FileNode> children;
    int size;

    FileNode(int dir) {
        this.intDir = dir;
        this.children = new LinkedList<>();
        this.size=0;
    }

    void mkdir(int dir) {
        children.add(new FileNode(dir));
        size++;
    }

    void rm(FileNode target) {
        children.remove(target);
        size--;
    }
    void add(FileNode target){
        children.add(target);
        size++;
    }


}

class UserSolution {

    private final static int NAME_MAXLEN = 6;
    private final static int PATH_MAXLEN = 1999;
    private static FileNode rootNode;

    void init(int n) {
        rootNode = new FileNode(0);
    }

    int getPathLen(char[] path) {
        int idx = 0;
        int length = -1;
        while (path[idx] != '\0') {
            if (path[idx] == '/')
                length++;
            idx++;
        }
        return length;
    }

    int[] pathByIntArray(char[] path) {
        int pathLength = getPathLen(path);
        int[] intPath = new int[pathLength];
        int idx = 0;
        int cursor1 = 0;
        int cursor2 = -1;
        for (int i = 1; i < path.length; i++) {
            char currentCharacter = path[i];
            if (currentCharacter == '/') {
                if (cursor2 == -1) {
                    cursor2 = i;
                    intPath[idx] = charArrToInt(path, cursor1 + 1, cursor2);
                    idx++;
                    cursor1 = cursor2;
                    cursor2 = -1;
                }
            }
        }
        return intPath;
    }

    void cp(FileNode src, FileNode dst) {
        Stack<FileNode> srcStack;
        Stack<FileNode> dstStack;

        srcStack = new Stack<>();
        dstStack = new Stack<>();

        srcStack.push(src);
        dstStack.push(dst);
        while (!srcStack.isEmpty() && !dstStack.isEmpty()) {
            FileNode src_popped = srcStack.pop();
            FileNode dst_popped = dstStack.pop();
            for (FileNode child : src_popped.children) {
                dst_popped.mkdir(child.intDir);
                srcStack.push(child);
            }
            for (FileNode child : dst_popped.children)
                dstStack.push(child);
        }
    }

    int charArrToInt(char[] path, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            result += path[i] - 'a' + 1;
            result = result << 5;
        }
        return result;
    }

    void cmd_mkdir(char[] path, char[] name) {
        int[] intArrPath = pathByIntArray(path);
        int intName = charArrToInt(name, 0, name.length-1);
        FileNode cursor = rootNode;
        int idx = 0;
        while (idx < intArrPath.length) {
            List<FileNode> children = cursor.children;
            int dir = intArrPath[idx];
            for (FileNode node : children) {
                if (node.intDir == dir) {
                    cursor = node;
                    break;
                }
            }
            idx++;
        }
        cursor.mkdir(intName);
    }

    void cmd_rm(char[] path) {
        int[] intArrPath = pathByIntArray(path);
        FileNode target = null;
        FileNode cursor = rootNode;
        int idx = 0;
        while (idx < intArrPath.length) {
            List<FileNode> children = cursor.children;
            int dir = intArrPath[idx];
            for (FileNode node : children) {
                if (node.intDir == dir) {
                    if (idx == intArrPath.length - 1) {
                        target = node;
                    } else {
                        cursor = node;
                    }
                    break;
                }
            }
            idx++;
        }
        cursor.rm(target);
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        int[] src = pathByIntArray(srcPath);
        int[] dst = pathByIntArray(dstPath);
        FileNode cursor = rootNode;
        FileNode srcNode = null;
        int idx = 0;
        while (idx < src.length) {
            List<FileNode> children = cursor.children;
            int dir = src[idx];
            for (FileNode node : children) {
                if (node.intDir == dir) {
                    if (idx == src.length - 1) {
                        srcNode = node;
                    } else {
                        cursor = node;
                    }
                    break;
                }
            }
            idx++;
        }
        idx = 0;
        cursor = rootNode;
        while (idx < dst.length) {
            List<FileNode> children = cursor.children;
            int dir = dst[idx];
            for (FileNode node : children) {
                if (node.intDir == dir) {
                    cursor = node;
                    break;
                }
            }
            idx++;
        }
        FileNode temp = new FileNode(srcNode.intDir);
        cursor.add(temp);
        cp(srcNode,temp);
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        int[] src = pathByIntArray(srcPath);
        int[] dst = pathByIntArray(dstPath);
        int idx=0;
        FileNode cursor = rootNode;
        FileNode target = null;
        while (idx < src.length) {
            List<FileNode> children = cursor.children;
            int dir = src[idx];
            for (FileNode node : children) {
                if (node.intDir == dir) {
                    if (idx == src.length - 1) {
                        target = node;
                    } else {
                        cursor = node;
                    }
                    break;
                }
            }
            idx++;
        }
        cursor.rm(target);
        idx=0;
        cursor=rootNode;
        while (idx<dst.length){
            List<FileNode> children = cursor.children;
            int dir = dst[idx];
            for(FileNode node: children){
                if(node.intDir == dir){
                    cursor = node;
                    break;
                }
            }
            idx++;
        }
        cursor.add(target);
    }

    int cmd_find(char[] path) {
        int[] src = pathByIntArray(path);
        Stack<FileNode> stack = new Stack<>();
        FileNode cursor = rootNode;
        int idx=0;
        int cnt=0;
        while (idx<src.length){
            List<FileNode> children = cursor.children;
            int dir = src[idx];
            for(FileNode node: children){
                if(node.intDir==dir){
                    cursor = node;
                    break;
                }
            }
            idx++;
        }
        stack.push(cursor);
        while (!stack.isEmpty()){
            FileNode poppedNode = stack.pop();
            cnt+=poppedNode.size;
            for(FileNode node: poppedNode.children){
                stack.push(node);
            }
        }
//        System.out.println(cnt);
        return cnt;
    }
}
