# Cumulative Lab 10
This Lab goes over some Android Developemnt fundamentals and then integrates in Ubiquitous Computing/IoT.

## Clone Command
The project contains submodules, so a simple ``` git clone``` won't pull all the required folders.  
Add the ```--recurse-submodules``` flag.  
### **Instead run**:
```
git clone --recurse-submodules https://github.com/V4G4X/Covid_Detection.git
```

## After Cloning
If you already did a simple ```git clone```, The Covid Detection App should be missing. This is because it has it's own independat git repo.
To get it's files  
### **Run**:
```
git submodule init
git submodule update
```