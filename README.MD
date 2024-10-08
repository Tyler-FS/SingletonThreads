After running my program I see that running multiple threads causes 
LazyInitializedSingleton to break the singleton rule of only having a single 
instance. ThreadSafeSingleton, however, maintains a single instance despite 
multiple threads running. 